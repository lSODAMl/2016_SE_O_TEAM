import static org.junit.Assert.*;

import org.junit.Test;

public class CLI_Checker_Test {

	@Test
	public void CheckOverThanInputTest(){

		CLI_Checker checker = new CLI_Checker();

		String[] str17 = {"-i","a.md", "-o","a.html","b.html"};
        String[] str18 = {"-i","a.md", "-o","a.html","-s","plain","fancy"};
        String[] str19 = {"-i", "a.md"};
        String[] str20 = {"-i", "a.md", "-o", "a.html"};

        assertEquals(false, checker.CheckOverThanInput(str17));
        assertEquals(false, checker.CheckOverThanInput(str18));
        assertEquals(true, checker.CheckOverThanInput(str19));
        assertEquals(true, checker.CheckOverThanInput(str20));

	}

	@Test
	public void ErrCheckTest(){

		CLI_Checker checker = new CLI_Checker();

        // CheckOutOfRange / CheckHelp / CheckOption
        String[] str1 = {""};
        String[] str2 = {"-help"};
        String[] str3 = {"-o", "a.html", "-i", "a.md"};
        String[] str4 = {"-s", "plain", "-i", "a.md"};

        checker.ErrCheck(str1);
        checker.ErrCheck(str2);
        checker.ErrCheck(str3);
        checker.ErrCheck(str4);

        //CheckNormalization
        String[] str5 = {"\\"};
        String[] str6 = {"/"};
        String[] str7 = {":"};
        String[] str8 = {"?"};
        String[] str9 = {"<"};
        String[] str10 = {">"};
        String[] str11 = {"|"};

        checker.ErrCheck(str5);
        checker.ErrCheck(str6);
        checker.ErrCheck(str7);
        checker.ErrCheck(str8);
        checker.ErrCheck(str9);
        checker.ErrCheck(str10);
        checker.ErrCheck(str11);

        //CheckNameFormant
        String[] str12 = {"-i","a.txt"};
        String[] str13 = {"=i", "a.md", "-o", "a.txt"};
        String[] str14 = {"-i", "a.md", "-s", "haein"};
        String[] str15 = {"-i", "a.md", "-o", "a.html", "-s", "teamO"};
        
        checker.ErrCheck(str12);
        checker.ErrCheck(str13);
        checker.ErrCheck(str14);
        checker.ErrCheck(str15);

        //CheckInputFile
        String[] str16 = {"-i", "b.md"};

        checker.ErrCheck(str16);

        //CheckOverThanInput
        String[] str17 = {"-i","a.md","-o","a.html","b.html"};
        String[] str18 = {"-i","a.md","-o","a.html","-s","plain","fancy"};

        checker.ErrCheck(str17);
        checker.ErrCheck(str18);

        // Good case
        String[] str19 = {"-i", "a.md"};
        String[] str20 = {"-i", "a.md", "-o", "a.html"};
        String[] str21 = {"-i", "a.md", "-s", "fancy"};
        String[] str22 = {"-i", "a.md", "-o", "a.html", "-s", "plain"};

        checker.ErrCheck(str19);
        checker.ErrCheck(str20);
        checker.ErrCheck(str21);
        checker.ErrCheck(str22);

  		}

	@Test
	public void CheckNormalizationTest(){

		CLI_Checker checker = new CLI_Checker();

        String[] str5 = {"\\"};
        String[] str6 = {"/"};
        String[] str7 = {":"};
        String[] str8 = {"?"};
        String[] str9 = {"<"};
        String[] str10 = {">"};
        String[] str11 = {"|"};
        String[] str12 = {"-i", "a.md"};

        checker.CheckNormalization(str5);
        checker.CheckNormalization(str6);
        checker.CheckNormalization(str7);
        checker.CheckNormalization(str8);
        checker.CheckNormalization(str9);
        checker.CheckNormalization(str10);
        checker.CheckNormalization(str11);
		checker.CheckNormalization(str12);
	}

	@Test
	public void CheckNameFormatTest(){

		CLI_Checker checker = new CLI_Checker();

		String[] str1 = {"-i","a.txt"};
        String[] str2 = {"=i", "a.md", "-o", "a.txt"};
        String[] str3 = {"-i", "a.md", "-s", "haein"};
        String[] str4 = {"-i", "a.md", "-o", "a.html", "-s", "teamO"};


        int option1 = checker.CheckOption(str1); 
        int option2 = checker.CheckOption(str2); 
        int option3 = checker.CheckOption(str3); 
        int option4 = checker.CheckOption(str4); 
        
       	assertEquals(false, checker.CheckNameFormat(str1, option1));
        assertEquals(true, checker.CheckNameFormat(str2, option2));
        assertEquals(false, checker.CheckNameFormat(str3, option3));
        assertEquals(false, checker.CheckNameFormat(str4, option4));

	}

	@Test
	public void CheckMDTest(){

		CLI_Checker checker = new CLI_Checker();

		String[] str1 = {"-i", "a.md"};
		String[] str2 = {"-i", "a.md", "-o", "a.html"};
		String[] str3 = {"-i", "a.txt"};
		String[] str4 = {"-i", "b.md"};

		checker.CheckMD(str1);
		checker.CheckMD(str2);
		checker.CheckMD(str3);
		checker.CheckMD(str4);

	}

	@Test
	public void CheckHTMLTest(){

		CLI_Checker checker = new CLI_Checker();

		String[] str1 = {"-i", "a.md", "-o", "a.html"};
		String[] str2 = {"-i", "a.md", "-o", "a.html", "-s", "fancy"};
		String[] str3 = {"-i", "a.md", "-o", "a.txt"};
		String[] str4 = {"-i", "a.md", "-o", "a.txt", "-s", "fancy"};

		checker.CheckHTML(str1);
		checker.CheckHTML(str2);
		checker.CheckHTML(str3);
		checker.CheckHTML(str4);
	}


	@Test
	public void CheckOutputFileTest(){

		CLI_Checker checker = new CLI_Checker();

		String file = "a";

		checker.CheckOutputFile(file);

	}


}
