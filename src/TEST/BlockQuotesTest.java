//package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
//import IR.BlockQuotes;

public class BlockQuotesTest {
	BlockQuotes block = new BlockQuotes();
	
	static String level1 = new String(">this is level1");
	static String level2 = new String(">>this is level2");
	static String level3 = new String(">>this is level3");


	@Test
	public void GetIdxTest(){
		assertTrue("BlockQuotesFail",  BlockQuotes.GetIdx()==0);
	}
	
	@Test
	public void IsBlockQuotesTest(){
		assertTrue("BlockQuotesFail", 1==BlockQuotes.IsBlockQuotes(level1, 1));
		assertTrue("BlockQuotesFail", 2==BlockQuotes.IsBlockQuotes(level3, 1));
		assertFalse("BlockQuotesFail", 5==BlockQuotes.IsBlockQuotes("", 0));
		assertFalse("BlockQuotesFail", 5==BlockQuotes.IsBlockQuotes("", 3));

	}
	@Test
	public void IsEndBlockQuotesTest(){
		assertTrue("BlockQuotesFail", BlockQuotes.IsEndBlockQuotes(""));
		assertFalse("BlockQuotesFail", BlockQuotes.IsEndBlockQuotes(level1));
		
	}
	
	
}