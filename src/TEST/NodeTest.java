
// package test;
 

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
//import IR.Node;


public class NodeTest {
	static String in = "somewhatnode";
    static Node node = new Node();

	
	@BeforeClass public static void justBefore(){
	    node = Node.create(in);
	}
	
	@Test
	public void createTest(){
		//Expected True
		assertTrue("Createfailed",  node.line.equals(in));
		
	}

}