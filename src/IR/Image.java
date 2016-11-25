package IR;

public class Image extends Token{
    public String altText = new String();
    public String src = new String();

    public static boolean IsImage(String str){
        if(str.matches("!\\[.*\\]\\(http://.*\\)")){
            return true;
        }
        else{
            return false;
        }
    }

}