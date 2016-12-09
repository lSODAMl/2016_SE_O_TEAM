//package team;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.w3c.tidy.Tidy;
//import Parser.*;
//import CLI.*;
//import IR.*;

public class Main {
	public static Document[] docs;
	public static CLI cli = new CLI();

    public static void main(String[] args) {


        // wrong condition
        if(!cli.Receive(args)){
            // err message or print something
        }

        // right condition
        else {
        	 // Converter
        	 cli.MakeHTML();

            // Get file names from CLI
            String[] files = cli.GetInput();
            // Parser start
            docs = new Document[files.length];

            for(int i = 0; i < docs.length; i++){
                docs[i] = new Document();
            }

            for(int i = 0; i < docs.length; i++){

                Parser.docParser(files[i],docs[i]);

                for(int j = 0; j < docs[i].docNodes.size(); j++){

                    Parser.nodeParser(docs[i].docNodes.get(j));
                    Node node = docs[i].docNodes.get(j);

                    for(int k = 0; k < node.nodes.size(); k++){

                        if(node.nodes.get(k).getClass().getSimpleName().equals("Node"))
                            Parser.tokenParser(node.nodes.get(k));

                    }
                }
            }

            for(int i = 0; i < docs.length; i++){
            	if(CLI.style[i].equals("plain"))
            		docs[i].accept(new PlainVisitor());
             	if(CLI.style[i].equals("fancy"))
            		docs[i].accept(new FancyVisitor());
            }


            try{
            CodeGenerator.file.write(CodeGenerator.msg);
            CodeGenerator.file.close();
            }

            catch(IOException e)
            {
            /*System.err.println(e);
            System.exit(1);*/
            }

            for(int i=0;i < docs.length; i++)
            {
            	try{

            	 File file=new File(CLI.output[i]);
                 InputStream is = new FileInputStream(file);
                 Tidy tidy1 = new Tidy();

                 tidy1.setXHTML(false);
                 tidy1.setDocType("html");
                 tidy1.setQuiet(false);
                 tidy1.setShowWarnings(true);
                 tidy1.setIndentContent(true);
                 tidy1.setSmartIndent(true);
                 tidy1.setIndentAttributes(false);
                 tidy1.setWraplen(0);
                 tidy1.getErrout();
                 ByteArrayOutputStream out1 = new ByteArrayOutputStream(1024);
                 tidy1.parse(is, out1);


                 FileOutputStream fos1 = new FileOutputStream(new File(CLI.output[i]));
                 out1.writeTo(fos1);

            	}

            	catch(IOException e){}

            }
        }
    }
}