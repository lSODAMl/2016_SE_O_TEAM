//package test;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class CLITest {
    String[] test1 = {"-i a.md","-s a.html","-o plain"};
    String[] test2 = {"fancy","slide"};
    @Test
    public void DivByTypeTest(){
        CLI cli = new CLI();
        cli.input = new String[3];
        cli.output = new String[3];
        cli.style = new String[3];


        cli.DivByType(test1);
        cli.DivByType(test2);
    }

    @Test
    public void FillByTypeTest(){
        CLI cli = new CLI();
        cli.input = new String[3];
        cli.output = new String[3];
        cli.output[0] = "a.html";
        cli.style = new String[3];
        cli.FillByType();
    }




}