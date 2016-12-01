//package IR;

public class CodeBlock extends Node{
    public boolean tag = true;
    public static boolean IsCodeBlock(String str) {
        if(str.equals("```"))
            return true;
        else
            return false;
    }
}
