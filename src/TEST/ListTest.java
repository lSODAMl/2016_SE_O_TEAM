//package TEST;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class ListTest {
    @Test
    public void testIsList(){
        List list = new List();
        boolean result = list.IsList("*a level 1");
        assertEquals(true,result);
    }
}
