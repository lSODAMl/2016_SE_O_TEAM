//package TEST;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;


/**
 * Created by LeeDongYoung on 2016-12-05.
 */
public class ListTest {
    @Test
    public void testIsList(){
        List list = new List();
        boolean result = list.IsList("*a level 1");
        assertEquals(true,result);
    }
}
