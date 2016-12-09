
// package test;
 

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
//import IR.Node;


public class NodeTest {
	static String in = "somewhatnode";
    static Node node = new Node();
	static PlainVisitor pVisitor = new PlainVisitor();
	static FancyVisitor fVisitor = new FancyVisitor();
	static Node no1 = new Node();
	static Node no2 = new Node();

	
	@BeforeClass public static void justBefore(){
		node = Node.create(in);
		no1.accept(pVisitor);
		no2.accept(fVisitor);
	}
	
	@Test
	public void createTest(){
		//Expected True
		assertTrue("Createfailed",  node.line.equals(in));
		
	}

}