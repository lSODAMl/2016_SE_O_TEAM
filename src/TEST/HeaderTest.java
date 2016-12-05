//package TEST;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;


/**
 * Created by LeeDongYoung on 2016-12-05.
 */
public class HeaderTest {
    @Test
    public void testIsHeader(){
        Header header = new Header();
        boolean result = header.IsHeader("# header 1");
        assertEquals(true,result);
    }
}
