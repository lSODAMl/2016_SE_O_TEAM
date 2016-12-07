
//package test;
 

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
//import IR.Token;


public class TokenTest {
	static String in = "somewhatnode";
    static Token tok = new Token();

	
	@BeforeClass public static void justBefore(){
	    tok = Token.create(in);
	}
	
	@Test
	public void createTest(){
		//Expected True
		assertTrue("Createfailed",  tok.tempStr.equals(in));
		
	}

}