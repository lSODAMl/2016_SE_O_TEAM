
//package test;
 

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
//import IR.Token;


public class TokenTest {
	static String in = "somewhatnode";
	static Token tok = new Token();

	static PlainVisitor pVisitor = new PlainVisitor();
	static FancyVisitor fVisitor = new FancyVisitor();
	static Token tok1 = new Token();
	static Token tok2 = new Token();

	@BeforeClass public static void justBefore(){
	    tok = Token.create(in);
		tok1.accept(pVisitor);
		tok2.accept(fVisitor);
	}
	
	@Test
	public void createTest(){
		//Expected True
		assertTrue("Createfailed",  tok.tempStr.equals(in));
		
	}

}