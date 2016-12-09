// package IR;

public class BlockQuotes extends Node{
    public boolean tag = true;
    public int level = 0;
    static private int idx = 0;
    /*
    we give level as parameter cuz if count is less than level, it is text.
    for example
    > level 1
    >> level 2
    >>>level 3
    > this is not new block quotes. It is just text
    */
    public static int IsBlockQuotes(String str,int level){
        int count = 0,i;
        char[] arr = str.toCharArray();
        for(i = 0; i < str.length();i++){
            if(arr[i] == '>')
                count++;
            else if(arr[i] == ' ')
                continue;
            else
                break;
        }

        if(count > level) {
            level = count;
            idx = i;
        }

        return level;
    }

    public static boolean IsEndBlockQuotes(String str){
        if(str.length() == 0)
            return true;
        else
            return false;
    }
    public static int GetIdx(){
        return idx;
    }
}
