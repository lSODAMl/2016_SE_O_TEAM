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
            System.out.println("nodeParser result");
            for(int i = 0; i < node.nodes.size();i++){
                if(node.nodes.get(i).getClass().getSimpleName().equals("Header")){
                    Header header = new Header();
                    header = (Header)node.nodes.get(i);
                    System.out.println(header.headerNum);
                }
                else{
                    System.out.println(node.nodes.get(i).token.tempStr);
                }

            }

            return;
         }
        // Other header


        // Else
    }

    public static void tokenParser(Node node){
        String s = node.token.tempStr;
        // image

        // link

        // style
        System.out.println("tokenParser result");

        if(Style.IsStyle(s))
            MakeStyle(node.token);


        for(int i = 0; i < node.token.tokens.size();i++){
            if(node.token.tokens.get(i).getClass().getSimpleName().equals("Text")){
                Text text = (Text)node.token.tokens.get(i);
                System.out.print(" text: "+text.text);
            }
            else if(node.token.tokens.get(i).getClass().getSimpleName().equals("Style")){
                Style style = (Style)node.token.tokens.get(i);
                System.out.print(" tok: "+style.category);
            }
        }
        System.out.println(" ");


        // text





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
}
