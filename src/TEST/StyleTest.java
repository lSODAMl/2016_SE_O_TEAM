package test;

import static org.junit.Assert.*;

import org.junit.Test;

import IR.Style;


public class StyleTest {

	
	@Test
	public void IsStyleTest() {
		//Expected True
		assertTrue("Stylefailed",  Style.IsStyle("__asd__"));
		assertTrue("Stylefailed",  Style.IsStyle("_***this_"));
		assertTrue("Stylefailed",  Style.IsStyle("==__should work__===_="));
		//Expected false
		assertFalse("Stylefailed",  Style.IsStyle("*_*****"));
		assertFalse("Stylefailed",  Style.IsStyle("this one_"));
		assertFalse("Stylefailed",  Style.IsStyle("sho_uldn'tbe"));
	}

	
}
