import java.util.ArrayList;
import Parser.*;
import CLI.*;
import IR.*;

public class Main {
    public static void main(String[] args) {
        CLI cli = new CLI();

        // wrong condition
        if(!cli.Receive(args)){
            // err message or print something
        }

        // right condition
        else {
            // Get file names from CLI
            String[] files = cli.GetInput();
            // Parser start
            Document[] docs = new Document[files.length];
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



            // Converter
            cli.MakeHTML();
            // Show result
            cli.CLI_Result();
        }
    }
}