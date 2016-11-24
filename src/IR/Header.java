//package IR;

public class Header extends Node{
    public int headerNum = 0;

    public static boolean IsHeader(String str){
        char[] splitLine = str.toCharArray();
        int count = 0;
        for(int i = 0; i < splitLine.length; i++) {
            if (splitLine[i] == '#')
                count++;
            else
                break;
        }
        if(count > 0 && count < 7) {
            if(count != splitLine.length)
                return true;
            else
                return false;
        }
        else
            return false;
    }
}
