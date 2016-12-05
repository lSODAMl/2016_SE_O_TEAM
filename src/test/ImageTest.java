//package TEST;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class ImageTest {

	private String link1 = "![Shohei Ohtani](http://imgnews.naver.net/image/109/2016/12/04/201612040356775243_5843266d27e70_99_20161204063603.jpg?type=w540)";
	private String link2 = "![this](will_make_an_error)";
	private String link3 = "![avatar](https://avatars0.githubusercontent.com/u/23257795?v=3&s=400)";
	
	@Test
	public void IsImageTest() {
		//Expected true
		assertTrue("Imagefailed",  Image.IsImage(link1));
		assertTrue("Imagefailed",  Image.IsImage(link3));

		//Expected false
		assertFalse("Imagefailed",  Image.IsImage(link2));	
	
	}

}


