//package TEST;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class MainTest {
    @Test
    public void testMain(){
        String dir = System.getProperty("user.dir");
        String[] s1 = {"-i","a.md","-o","a.html","-s","plain"};
        String[] s2 = {"-help"};
        String[] s3 = {"-i","a.md","-s","plain"};
        String[] s4 = {"-i","a.md","-o","a.html"};
        String[] s5 = {"-i","a.md","-s","plain","-o","a.html"};

        Main m = new Main();
        m.main(s1);
        m.main(s2);
        m.main(s3);
        m.main(s4);
    }
}