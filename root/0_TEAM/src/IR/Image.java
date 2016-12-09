//package IR;

public class Image extends Token{
    public String altText = new String();
    public String src = new String();
    public boolean tag = true;
    public static boolean IsImage(String str){
        if(str.matches("!\\[.*\\]\\(http://.*\\)"))
            return true;
        else if(str.matches("!\\[.*\\]\\(https://.*\\)"))
        	return true;
        else
            return false;
        
    }

}
