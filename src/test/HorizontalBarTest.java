//package TEST;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;


public class HorizontalBarTest { 
	
	@Test
	public void IsHorizontalTest() {
		//Expected True
		assertTrue("HorizontalBarfailed",  HorizontalBar.IsHorizontal("******"));
		assertTrue("HorizontalBarfailed",  HorizontalBar.IsHorizontal("--------"));
		assertTrue("HorizontalBarfailed",  HorizontalBar.IsHorizontal("======"));
		//Expected false
		assertFalse("HorizontalBarfailed",  HorizontalBar.IsHorizontal("****a****"));
		assertFalse("HorizontalBarfailed",  HorizontalBar.IsHorizontal("***---"));
		assertFalse("HorizontalBarfailed",  HorizontalBar.IsHorizontal("===---"));

	}

}
