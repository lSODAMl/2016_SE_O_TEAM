//package CLI;
import java.io.*;
import java.util.*;

public class CLI {
    public static String input[], output[];
    public static String style[];
    CLI_Checker checker = new CLI_Checker();

    public boolean Receive(String[] args){
        if(!checker.ErrCheck(args)){
            return false;
        }

        else{
            CreateType();
            DivByType(args);
            FillByType();
            return true;
        }
    }

    public void CreateType(){
        int size = checker.input_count;
        input = new String[size];
        output = new String[size];
        style = new String[size];

    }

    public void DivByType(String[] args){
        int inputCount = 0, outputCount = 0, styleCount = 0;

        for(int i = 0; i < args.length; i++){
            if(args[i].matches(".*md"))
                input[inputCount++] = args[i];

            else if(args[i].matches(".*html"))
                output[outputCount++] = args[i];

            else if(args[i].equals("plain") || args[i].equals("fancy") || args[i].equals("slide"))
            {
                style[styleCount++] = args[i];
            }
         }
    }

    public void FillByType(){
        for(int i = 0; i < input.length; i++) {
            if (output[i] == null) {
                output[i] = input[i].split(".md")[0];
                output[i] = output[i].concat(".html");
            }

            if(output[i] != null)
                output[i] = output[i].split(".html")[0];

            if(style[i] == null)
                style[i] = "plain";
        }
    }

    public String[] GetInput(){
        return input;
    }
    public void MakeHTML(){
        for(int i = 0; i < input.length; i++){
            try
            {
                output[i] = checker.CheckOutputFile("../doc/" + output[i]);
                output[i] = output[i].concat(".html");
                FileWriter fw = new FileWriter(output[i]);
                BufferedWriter bw = new BufferedWriter(fw);
               // bw.newLine();
               // bw.close();
            }
            catch (IOException e)
            {
                System.err.println(e);
                System.exit(1);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public void CLI_Result(){
        System.out.println("==CLI_Result==");
        for(int i = 0; i < input.length; i++){
            System.out.println(i+1 +" File:");
            System.out.print(input[i]+" | ");
            System.out.print(output[i]+" | ");
            System.out.print(style[i]);
            System.out.println("");
        }
    }
}
