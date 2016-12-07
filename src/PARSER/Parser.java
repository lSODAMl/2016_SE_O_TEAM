// package PARSER;

import java.io.*;
import java.io.File;
import java.util.ArrayList;
//import IR.*;

public class Parser {
    static private boolean codeFlag = false;
    static private boolean pFlag = false;
    static private int bqLevel = 0;
    static private int bqCount = 0;
    static private int listLevel = 0;
    static public ArrayList<Integer> listType = new ArrayList<Integer>();

    public static void docParser(String fileName, Document doc){
        String directory = "../";
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
        int tempLevel;
        int tempType;

        // block quotes >
        if((tempLevel =BlockQuotes.IsBlockQuotes(line,bqLevel)) > bqLevel){
            bqLevel = tempLevel;
            bqCount++;
            int idx = BlockQuotes.GetIdx();
            line = line.substring(idx);
            MakeBlockQuotes(node,line,bqLevel);
        }

        if(BlockQuotes.IsEndBlockQuotes(line)){
            EndBlockQuotes(node,bqCount);
            bqCount = 0;
            bqLevel = 0;
        }

        // Conform code block
        // </CodeBlock>
        if(codeFlag && CodeBlock.IsCodeBlock(line)){
            MakeCodeBlock(node,codeFlag);
            codeFlag = false;
        }
        // in use -> text
        else if(codeFlag && !CodeBlock.IsCodeBlock(line)){
            Node tempNode = new Node();
            tempNode.token = Token.create(node.line);
            node.nodes.add(tempNode);
        }
        // <CodeBlock>
        else if(!codeFlag && CodeBlock.IsCodeBlock(line)){
            if(pFlag){
                pFlag = false;
                MakeParagraph(node, line, pFlag);
            }

            MakeCodeBlock(node,codeFlag);
            codeFlag = true;
        }
        ////////////////////

        // List

        else if(List.IsList(line)){
            if(pFlag){
                pFlag = false;
                MakeParagraph(node, line, pFlag);
            }
            tempLevel = List.WhatIsLevel(line,listLevel);
            // line: 1. text or * text
            line = line.substring(List.getIdx());
            tempType = List.WhatIsType(line);
            // line: just text
            line = line.substring(2);

            if(tempLevel > 0){
                listLevel++;
                if(tempType == 1)
                    listType.add(0,1);
                else
                    listType.add(0,2);

                MakeList(node,line,1,listType);
            }
            else if(tempLevel == 0) {
                MakeList(node, line, 0, listType);
            }
            else {
                if(tempType == 1)
                    listType.add(0,1);
                else
                    listType.add(0,2);

                MakeList(node,line,tempLevel/2,listType);
                listLevel = listLevel+ tempLevel/2;
            }
        }

        else if(List.IsEndList(line)){
            int size = listType.size();
            for(int i = 0; i < size; i++){
                int type = listType.get(0);
                List list = new List();
                if(type == 1)
                    list.ul = -1;
                else
                    list.ol = -1;
                node.nodes.add(list);
                listType.remove(0);
                listLevel = 0;
            }
        }
        ////////////////////


        // Conform header
        else if(Header.IsHeader(line)){
            if(pFlag){
                pFlag = false;
                MakeParagraph(node, line, pFlag);
            }

            MakeHeader(node, line);
            return;
        }

        // Conform horizontal bar
        else if(HorizontalBar.IsHorizontal(line)){
            if(pFlag){
                pFlag = false;
                MakeParagraph(node, line, pFlag);
            }

            MakeHorizontalBar(node);
        }

        // Conform p tag
        else if(!pFlag&& bqCount == 0 && line.length() != 0){
            pFlag = true;
            MakeParagraph(node, line, pFlag);
        }

        // Else - just token
        else{
            Node tempNode = new Node();
            tempNode.token = Token.create(line);
            node.nodes.add(tempNode);
        }
    }
    public static void tokenParser(Node node){
        String s = node.token.tempStr;
        // image
        if(Image.IsImage(s))
            MakeImg(node.token);
            // link
        else if(Link.IsLink(s))
            MakeLink(node.token);
            // style
        else if(Style.IsStyle(s))
            MakeStyle(node.token);
            // text
        else{
            MakeText(node.token);
        }
    }

    public static void MakeHeader(Node node, String line){
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

        header = new Header();
        header.headerNum = pos;
        header.tag = false;
        node.nodes.add(header);
    }
    public static void MakeHorizontalBar(Node node){
        HorizontalBar bar = new HorizontalBar();
        node.nodes.add(bar);
    }
    public static void MakeCodeBlock(Node node, boolean flag){
       CodeBlock codeBlock = new CodeBlock();

        // if flag is true -> in use so </codeBlock>
        // else flag is false -> do not use so <codeBlock>
        if(flag)
            codeBlock.tag = false;
        else
            codeBlock.tag = true;

        node.nodes.add(codeBlock);
    }
    public static void MakeParagraph(Node node, String line, boolean flag){
        Paragraph p = new Paragraph();
        if(flag) {
            node.nodes.add(p);
            Node tempNode = new Node();
            tempNode.token = Token.create(line);
            node.nodes.add(tempNode);
        }
        else{
            p.tag = flag;
            node.nodes.add(p);
        }
    }
    public static void MakeBlockQuotes(Node node,String line, int level){
        BlockQuotes bq = new BlockQuotes();
        bq.tag = true;
        bq.level = level;
        node.nodes.add(bq);
    }
    public static void EndBlockQuotes(Node node, int count){
        for(int i = 0; i < count; i++){
            BlockQuotes bq = new BlockQuotes();
            bq.tag = false;
            node.nodes.add(bq);
        }
    }

    public static void MakeList(Node node, String line, int state, ArrayList<Integer> type){
        List list = new List();

        // increase level & add list
        if(state == 1){
            if(type.get(0) == 1)
                list.ul = 1;
            else
                list.ol = 1;

            // add <ul> or <ol>
            node.nodes.add(list);

            // add <li>
            list = new List();
            list.li = 1;
            node.nodes.add(list);

            // add text(Token)
            Node tempNode = new Node();
            tempNode.token = Token.create(line);
            node.nodes.add(tempNode);

            // add </li>
            list = new List();
            list.li = -1;
            node.nodes.add(list);
        }

        // decrease level & add list
        else if(state < 0){
            int end = -state;

            int listType = 0;
            for(int i = 0; i < end; i++){
                listType = type.get(1);
                list = new List();
                if(listType == 1)
                    list.ul = -1;
                else
                    list.ol = -1;
                node.nodes.add(list);
                type.remove(1);
            }

            list = new List();

            if(type.get(0) == 1)
                list.ul = 1;
            else
                list.ol = 1;

            // add <ul> or <ol>
            node.nodes.add(list);

            // add <li>
            list = new List();
            list.li = 1;
            node.nodes.add(list);

            // add text(Token)
            Node tempNode = new Node();
            tempNode.token = Token.create(line);
            node.nodes.add(tempNode);

            // add </li>
            list = new List();
            list.li = -1;
            node.nodes.add(list);
        }

        // current level
        else{
            // add <li>
            list.li = 1;
            node.nodes.add(list);

            // add text(Token)
            Node tempNode = new Node();
            tempNode.token = Token.create(line);
            node.nodes.add(tempNode);

            // add </li>
            list = new List();
            list.li = -1;
            node.nodes.add(list);
        }
    }
    public static void MakeStyle(Token tok){
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

            else if (s.matches(".*\\*.*\\*.*") || s.matches(".*\\*\\*.*\\*\\*.*")){
                idx = s.indexOf('*');
                if(s.charAt(idx + 1) == '*')
                    symbol = "**";

                else
                    symbol = "*";

                if(idx != 0){
                    if(symbol.equals("*")){
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
                    if(symbol.equals("*")){
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
    public static void MakeLink(Token tok){
        String s = tok.tempStr;
        String href = new String();
        String linkName = new String();
        if(s.matches("\\[.*\\]\\(http://.*\\)")){
            int idx = s.indexOf("(");
            href = s.substring(idx +1,s.length()-1);
            linkName = s.substring(s.indexOf("[")+1,s.indexOf("]"));
            Link link = new Link();
            link.href = href;
            link.linkName = linkName;
            tok.tokens.add(link);
        }

        else{
            Link link = new Link();
            link.href = s;
            tok.tokens.add(link);
        }
        Link lnk = new Link();
        lnk.tag = false;
        tok.tokens.add(lnk);

    }
    public static void MakeImg(Token tok){
        String s = tok.tempStr;
        String altText = new String();
        String src = new String();
        if(s.matches("!\\[.*\\]\\(http://.*\\)")){
            int idx = s.indexOf("(");
            src = s.substring(idx +1,s.length()-1);
            altText = s.substring(s.indexOf("[")+1,s.indexOf("]"));
            Image img = new Image();
            img.altText = altText;
            img.src = src;
            tok.tokens.add(img);
        }
    }
    public static void MakeText(Token tok){
        tok.tokens.add(new Text(tok.tempStr));
    }
}