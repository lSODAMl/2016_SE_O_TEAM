package test;

import static org.junit.Assert.*;

import org.junit.Test;

import IR.Image;

public class ImageTest {

	private String link1 = "![Shohei Ohtani](http://imgnews.naver.net/image/109/2016/12/04/201612040356775243_5843266d27e70_99_20161204063603.jpg?type=w540)";
	private String link2 = "![this](will_make_an_error)";

	
	@Test
	public void IsImageTest() {
		//Expected true
		assertTrue("Imagefailed",  Image.IsImage(link1));

		//Expected false
		assertFalse("Imagefailed",  Image.IsImage(link2));	
	
	}

}


