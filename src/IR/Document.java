//package IR;

import java.util.ArrayList;

public class Document {
    public ArrayList<Node> docNodes = new ArrayList<Node>();
    public ArrayList<String> lines = new ArrayList<String>();
    public static Document create(){
        return new Document();
    }
    

  public void accept(MDElementVisitor v)
  {
	  v.visitDocument(this);
  }
}
