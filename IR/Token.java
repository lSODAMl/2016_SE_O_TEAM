package IR;

import java.util.ArrayList;

public class Token implements MDElement{
    public ArrayList<Token> tokens = new ArrayList<Token>();
    public String tempStr;
    int[][] category = new int[3][];
    public static Token create(String str){
        Token tok = new Token();
        tok.tempStr = str;
        return tok;
    }
}
