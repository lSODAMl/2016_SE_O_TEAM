//package test;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
//import IR.Document;
public class DocumentTest {
	static PlainVisitor pVisitor = new PlainVisitor();
	static FancyVisitor fVisitor = new FancyVisitor();
	static Document doc1 = new Document();
	static Document doc2 = new Document();

	@BeforeClass static public void justBefore(){
		doc1.accept(pVisitor);
		doc2.accept(fVisitor);
	}
	@Test
	public void createTest(){
		assertNotNull("DocumentFail",Document.create());
	}
	

}
