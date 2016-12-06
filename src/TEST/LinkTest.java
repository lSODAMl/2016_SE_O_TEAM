//package test;

import static org.junit.Assert.*;

import org.junit.Test;

import IR.Link;

public class LinkTest {
	private String link1 = "www.naver.com";
	private String link2 = "[Wiki](https://en.wikipedia.org/wiki/Main_Page)";

	private String link3 = "http://hisnet.handong.edu";
	private String link4 = "[Facebook](www.facebook.com)";

	private String link5 = "hisnet.handong.edu";
	private String link6 = "[Github](https://github.com/lSODAMl/2016_SE_O_TEAM)";
	
	@Test
	public void IsLinkTest(){
		//Expected True
		assertTrue("Linkfailed",  Link.IsLink(link1));
		assertTrue("Linkfailed",  Link.IsLink(link2)); 
		assertTrue("Linkfailed",  Link.IsLink(link6)); 

		//Expected false
		assertFalse("Linkfailed",  Link.IsLink(link3));
		assertFalse("Linkfailed",  Link.IsLink(link4));
		assertFalse("Linkfailed",  Link.IsLink(link5));
		
	}
}
