package IR;

/**
 * Created by LeeDongYoung on 2016-11-25.
 */
public class Link extends Token{
    public String href = new String();
    public String linkName = new String();
    public static boolean IsLink(String str){
        if(str.matches("\\[.*\\]\\(http://.*\\)"))
            return true;

        else if(str.matches("www\\..*"))
            return true;

        else
            return false;
    }
}
