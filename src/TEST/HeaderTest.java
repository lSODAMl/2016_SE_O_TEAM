//package test;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

//import IR.Header;

public class HeaderTest {
	String str1 = new String("");
	String str2 = new String("##somewhatlike this");
	String str3 = new String("#########somewhatlike this");
	String str4 = new String("#####");

	
	
	@Test
    public void IsHeaderTest(){
		assertFalse("HeaderFail",  Header.IsHeader(str1));
		assertTrue("HeaderFail",  Header.IsHeader(str2));
		assertFalse("HeaderFail",  Header.IsHeader(str3));
		assertFalse("HeaderFail",  Header.IsHeader(str4));

    }
}