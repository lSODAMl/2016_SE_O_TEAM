//package test;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
//import IR.List;

public class ListTest {
	String str1 = new String("- unord");
	String str2 = new String("+ unord");
	String str3 = new String("* unord");
	String str4 = new String("1. ord");

	List list = new List();
	@Test
	public void Set_GetIdxTest(){
		List.SetIdx(10);
		assertTrue("ListFail",List.getIdx()==10);
	}
	@Test
	public void IsEndListTest(){
		assertTrue("ListFail",List.IsEndList(""));
		assertFalse("ListFail",List.IsEndList("somewhat"));
		
	}
	@Test
	public void WhatIsTypeTest(){
		assertEquals("ListFail", 1, List.WhatIsType(str1));
		assertEquals("ListFail", 1, List.WhatIsType("* like this form*"));
		assertEquals("ListFail", 1, List.WhatIsType("+ like this form+"));
		assertEquals("ListFail", 2, List.WhatIsType(str4));

	}
	@Test
	public void IsListTest(){
		assertTrue("ListFail",List.IsList(str1));
		assertTrue("ListFail",List.IsList(str2));
		assertTrue("ListFail",List.IsList(str3));
		assertTrue("ListFail",List.IsList(str4));
		assertTrue("ListFail",List.IsList("   * somewhat like this")); //2,3
		assertTrue("ListFail",List.IsList("   /1 a*")); //2,3

		assertFalse("ListFail",List.IsList(""));  //1
		assertFalse("ListFail",List.IsList("somewhat"));
		assertFalse("ListFail",List.IsList("++--"));

		
	}
	@Test
	public void WhatIsLevelTest(){
		assertEquals("ListFail",0, List.WhatIsLevel(str1, 1));
		assertNotEquals("ListFail",2, List.WhatIsLevel("  "+str1, 1));
		assertNotEquals("ListFail",3, List.WhatIsLevel("", 3));
		assertNotEquals("ListFail",4, List.WhatIsLevel(str1, 4));
		
	}

}