//package test;

import static org.junit.Assert.*;

import org.junit.Test;

//import IR.Style;


public class StyleTest {
	static String str = new String("this_is_style");
	static Style style = new Style(str, true);

	@Test
	public void Style_Test(){
		assertTrue("Stylefailed",  style.category.equals(str));
		assertTrue("Stylefailed",  style.tag);

	}
	
	@Test
	public void IsStyleTest() {
		//Expected True
		assertTrue("Stylefailed",  Style.IsStyle("__asd__"));
		assertTrue("Stylefailed",  Style.IsStyle("and_this_one"));
		assertTrue("Stylefailed",  Style.IsStyle("something__like__this"));
		//Expected false
		assertFalse("Stylefailed",  Style.IsStyle("*_*****"));
		assertFalse("Stylefailed",  Style.IsStyle("*__*****"));
		assertFalse("Stylefailed",  Style.IsStyle("this one_"));
		assertFalse("Stylefailed",  Style.IsStyle(""));

	}

	
}