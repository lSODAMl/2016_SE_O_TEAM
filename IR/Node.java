package IR;

import java.util.ArrayList;

public class Node {
    public ArrayList<Node> nodes = new ArrayList<Node>();
    public Token token = new Token();
    public String line;
    public static Node create(String str){
        Node node = new Node();
        node.line = str;
        return node;
    }
}
