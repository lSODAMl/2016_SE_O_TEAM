import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
//import CLI.*;
//import IR.*;
//import PARSER.*;
//import CODEGEN.*;

public class DocumentTest {
	static PlainVisitor pVisitor = new PlainVisitor();
//	static FancyVisitor fVisitor = new FancyVisitor();
	static Document doc1 = new Document();
	static Document doc2 = new Document();
	static Node node = new Node();
	static String str = new String("somewhat");
	static CodeGenerator cod = new CodeGenerator();
	@BeforeClass static public void justBefore(){
		doc1.accept(pVisitor);
//		doc2.accept(fVisitor);
		
		node.line="* H1";
		doc1.docNodes.add(0, node);
		doc1.lines.add(0,str);
		cod.setNode(node,0,0,1);
	}
	@Test
	public void createTest(){
		assertNotNull("DocumentFail",Document.create());
	}
	

}
