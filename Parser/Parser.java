package Parser;

import java.io.*;
import java.io.File;
import java.util.ArrayList;
import IR.*;

public class Parser {
    public static void docParser(String fileName, Document doc){
        String directory = "";
        File file = new File(directory+fileName);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String s;
            while((s = in.readLine()) != null)
                doc.docNodes.add(Node.create(s));

        }catch (IOException e){
            System.err.println(e);
            System.exit(1);
        }
    }
    public static void nodeParser(Node node){
        String line = node.line;
        // Conform header
        if(Header.IsHeader(line)){
            MakeHeader(node, line);

            return;
        }
        // Conform other node
        //...

        // Else - just token
        else{
            Node tempNode = new Node();
            tempNode.token = Token.create(node.line);
            node.nodes.add(tempNode);
        }
    }

    public static void tokenParser(Node node){
        String s = node.token.tempStr;
        // image

        // link

        // style
        if(Style.IsStyle(s))
            MakeStyle(node.token);

            // text
        else{
            MakeText(node.token);
        }
    }

    //public static void tokenParser(Node node);
    private static void MakeHeader(Node node, String line){
        int pos = 0;
        for(int i = 0; i <line.length();i++){
            if(line.charAt(i) != '#') {
                pos = i;
                break;
            }
        }
        Header header = new Header();
        header.headerNum = pos;
        node.nodes.add(header);

        Node tempNode = new Node();
        tempNode.token = Token.create(line.substring(pos));
        node.nodes.add(tempNode);
    }
    private static void MakeStyle(Token tok){
        int idx = 0;
        String symbol = new String(), s = tok.tempStr;

        while(true){
            // style exist
            if (s.matches(".*_.*_.*") || s.matches(".*__.*__.*")){
                idx = s.indexOf('_');
                if(s.charAt(idx + 1) == '_')
                    symbol = "__";

                else
                    symbol = "_";

                if(idx != 0){
                    if(symbol.equals("_")){
                        tok.tokens.add(new Text(s.substring(0,idx)));
                        tok.tokens.add(new Style(symbol, true));
                        s = s.substring(idx + 1);
                        idx = s.indexOf(symbol);
                        tok.tokens.add(new Text(s.substring(0,idx)));
                        tok.tokens.add(new Style(symbol,false));
                        s = s.substring(idx + 1);
                    }

                    else{
                        tok.tokens.add(new Text(s.substring(0,idx)));
                        tok.tokens.add(new Style(symbol, true));
                        s = s.substring(idx + 2);
                        idx = s.indexOf(symbol);
                        tok.tokens.add(new Text(s.substring(0,idx)));
                        tok.tokens.add(new Style(symbol,false));
                        s = s.substring(idx + 2);
                    }
                }


                else{
                    if(symbol.equals("_")){
                        tok.tokens.add(new Style(symbol, true));
                        s = s.substring(idx + 1);
                        idx = s.indexOf(symbol);
                        tok.tokens.add(new Text(s.substring(0,idx)));
                        tok.tokens.add(new Style(symbol,false));
                        s = s.substring(idx + 1);
                    }

                    else{
                        tok.tokens.add(new Style(symbol, true));
                        s = s.substring(idx + 2);
                        idx = s.indexOf(symbol);
                        tok.tokens.add(new Text(s.substring(0,idx)));
                        tok.tokens.add(new Style(symbol,false));
                        s = s.substring(idx + 2);
                    }
                }
            }
            // style is not exist
            else {
                if(!s.equals(""))
                    tok.tokens.add(new Text(s));
                else{}
                break;
            }
        }

    }
    private static void MakeText(Token tok){
        tok.tokens.add(new  Text(tok.tempStr));
    }
}
