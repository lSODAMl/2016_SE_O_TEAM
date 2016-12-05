package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import IR.Node;


public class NodeTest {
	static String in = "somewhatnode";
	static String out;
	@BeforeClass public static void justBefore(){
	    Node.create(in);
	    out = Node.line;
	}
	
	@Test
	public void createTest(){
		//Expected True
		assertTrue("Createfailed",  out.equals(in));
		
	}

}