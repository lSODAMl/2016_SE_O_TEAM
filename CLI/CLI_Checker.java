package CLI;

import java.io.File;

public class CLI_Checker {
    private int option = 0;
    public int input_count = 0;
    public boolean ErrCheck(String[] args){
        try {
            if(CheckOutOfRange(args)){
                throw new Exception("Please input command");
            }

            if(CheckHelp(args[0])){
                String str = "\nType as: java class [md file] [html file] [plain/fancy/slide]" +"\n"+
                        "md file is '.md' file. html file is '.html' file that you want to create."+"\n"+
                        "If a specific name of html file already exists, it add some number that html file."+"\n"+
                        "html file=>If omitted, html file is created as md file.html(same name as md file)."+"\n"+
                        "plain/fancy/slide=>If omitted, plain is the default option."+"\n"+
                        "plain : Creates basic html file."+"\n"+
                        "fancy : Creates more style added html file like CSS."+"\n"+
                        "slide : Creates html file that supports slide function."+"\n"+
                        "For options: java class [-option] "+"\n"+
                        "-help : Lists using format and all the options."+"\n";

                throw new Exception(str);
            }

            option = CheckOption(args);
            if(option == -1){
                throw new Exception("Please check option/s");
            }

            if(!CheckNormalization(args)){
                throw new Exception("Please check file name." + " You can't use \\ / : ? < > | ");
            }

            if(!CheckNameFormat(args,option)){
                throw new Exception();
            }

            if(!CheckInputFile(args))
                throw new Exception("md file is not exist in your dir");

            if(!CheckOverThanInput(args))
                throw new Exception("output or style command is more than input");

            return true;

        }catch (Exception e){
            System.out.println(e);
            return false;
        }

    }

    private boolean CheckOutOfRange(String[]args){
        if(args.length == 0)
            return true;
        else
            return false;
    }

    private boolean CheckHelp(String msg){
        if(msg.equals("-help"))
            return true;
        else
            return false;
    }

    private int CheckOption(String[] args) {
        int inputCount = 0, outputCount = 0, styleCount = 0, optionCount = 0;
        int inputPosition = 0, outputPosition = 0, stylePosition = 0;

        // Count option number
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-i")) {
                inputCount++;
                inputPosition = i;
            }
            if (args[i].equals("-o")) {
                outputCount++;
                outputPosition = i;
            }
            if (args[i].equals("-s")) {
                styleCount++;
                stylePosition = i;
            }
        }

        // Check option count
        if (inputCount != 1 || outputCount > 2 || styleCount > 2) {
            return -1;
        }

        // Check -o position
        if(inputPosition != 0)
            return -1;

        // CHECK option order
        if (outputPosition > stylePosition && stylePosition != 0) {
            return -1;
        }

        optionCount = inputCount + outputCount + styleCount;

        if(outputCount == 0 && styleCount == 1)
            optionCount = 3;
        if(outputCount == 1 && styleCount == 1)
            optionCount = 4;

        return optionCount;
    }

    private boolean CheckNormalization(String[] args){
        boolean flag = true;
        int i = 0;

        for(i = 0; i < args.length; i++){
            if(args[i].contains("\\")){
                flag = false;
                break;
            }

            else if(args[i].contains("/")){
                flag = false;
                break;
            }

            else if(args[i].contains(":")){
                flag = false;
                break;
            }

            else if(args[i].contains("?")){
                System.out.println("result"+"?");
                flag = false;
                break;
            }

            else if(args[i].contains("<")){
                System.out.println("result"+"<");
                flag = false;
                break;
            }

            else if(args[i].contains(">")){
                System.out.println("result"+">");
                flag = false;
                break;
            }

            else if(args[i].contains("|")){
                System.out.println("result"+"|");
                flag = false;
                break;
            }
        }

        return flag;
    }

    private boolean CheckNameFormat(String[] args, int option){
        boolean flag = true;
        // Check md
        if(!CheckMD(args)){
            System.out.println("md file format err");
            flag = false;
        }

        // Check html / style
        if(option >= 2){
            // Check html
            if(!CheckHTML(args)) {
                System.out.println("html file format err");
                flag = false;
            }
            // CHECK style
            if(!CheckStyle(args)){
                System.out.println("style format err");
                flag = false;
            }

        }
        return flag;
    }

    private boolean CheckMD(String[] args){
        boolean flag = true;
        for(int i = 1; i < args.length;i++){
            if(args[i].equals("-o") || args[i].equals("-s")) {
                break;
            }

            if(!args[i].matches(".*md")){
                flag = false;
                break;
            }
        }

        return flag;
    }

    private boolean CheckHTML(String[] args){
        int output_position = 0;
        for(int i = 0; i < args.length;i++){
            if(args[i].equals("-o")) {
                output_position = i;
                break;
            }
        }

        // -o option is not exists
        if(output_position == 0)
            return true;

        else{
            for(int i = output_position + 1; i < args.length; i++){
                if(args[i].equals("-s"))
                    break;

                if(!args[i].matches(".*html")){
                    System.out.println(args[i]);
                    return false;
                }
            }
            return true;
        }
    }

    private boolean CheckStyle(String[] args){
        int style_position = 0;
        for(int i = 0; i < args.length;i++){
            if(args[i].equals("-s")) {
                style_position = i;
                break;
            }
        }

        // -s option is not exists
        if(style_position == 0)
            return true;

        if(style_position == args.length-1)
            return true;

        else{
            for(int i = style_position + 1; i < args.length; i++){
                if(!args[i].equals("fancy") && !args[i].equals("slide") && !args[i].equals("plain")){
                    return false;
                }
            }
            return true;
        }
    }

    private boolean CheckInputFile(String[] args){
        // Please change directory
        String directory ="./";

        for(int i = 1; i < args.length;i++){
            if(args[i].equals("-o") || args[i].equals("-s"))
                break;
            File file = new File(directory+"/"+args[i]);
            if(!file.isFile())
                return false;
        }
        return true;
    }

    public String CheckOutputFile(String html){
        String f_name = html;
        // Please change directory
        for(int i = 0; ; i++){
            String directory ="./";
            if(i != 0)
                f_name = html+"("+i+")";
            File file = new File(f_name+".html");

            if(file.isFile()){
            }
            else{
                return f_name;
            }
        }
    }

    private boolean CheckOverThanInput(String[] args){
        int inputCount = 0, outputCount = 0, styleCount = 0;
        for(int i = 0; i < args.length; i++){
            if(args[i].matches(".*md"))
                inputCount++;

            else if(args[i].matches(".*html"))
                outputCount++;

            else if(args[i].equals("plain") || args[i].equals("fancy") || args[i].equals("slide"))
                styleCount++;
        }

        if(inputCount < outputCount){
            return false;
        }

        if(inputCount < styleCount){
            return false;
        }

        this.input_count = inputCount;
        return true;
    }
}
