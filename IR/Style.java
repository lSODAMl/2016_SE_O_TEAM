package IR;

public class Style extends Token{
    // <em>: '_' | <strong>: '__'
    public String category = new String();
    // <tag>: true | </tag>: false
    public boolean tag = true;

    public Style(String s, boolean tag){
        category = s;
        this.tag = tag;
    }

    public static boolean IsStyle(String s) {
        if (s.matches(".*_.*_.*") || s.matches(".*__.*__.*"))
            return true;
        else
            return false;
    }
}
