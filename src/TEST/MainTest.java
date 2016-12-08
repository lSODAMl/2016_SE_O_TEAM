//package TEST;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class MainTest {
    @Test
    public void testMain(){
        String dir = System.getProperty("user.dir");
        String[] s = {"-i","a.md"};
        Main m = new Main();
        m.main(s);
    }
}