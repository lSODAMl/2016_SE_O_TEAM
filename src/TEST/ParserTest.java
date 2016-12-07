//package TEST;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class ParserTest {

	@Test
	public void docParserTest(){
		// directory -> file -> ioException
	}

	@Test
	public void nodeParserTest(){
		// blockquotes -> codeblock -> list
		// header -> hr bar -> paragraph
	}

	@Test
	public void tokenParserTest(){
		// img -> link -> style -> text
	}


	// size of the header case
	@Test
	public void MakeHeaderTest() {

		Parser parser = new Parser();
		String str = "#### h4";
		Node node = new Node();
		parser.MakeHeader(node , str);

		String node_name = node.nodes.get(0).getClass().getSimpleName();
		boolean check = node_name.equals("Header");
		assertEquals(true, check);

	}

	// temp completed
	@Test
	public void MakeHorizontalBarTest(){
		Parser parser = new Parser();
		String str = "*****";
		Node node = new Node();
		node.line = str;
		parser.MakeHorizontalBar(node);

		String node_name = node.nodes.get(0).getClass().getSimpleName();
		// System.out.println(node_name);
		boolean check = node_name.equals("HorizontalBar");
		assertEquals(true, check);

	}

	// code open / close case
	@Test
	public void MakeCodeBlockTest(){

		// case1 : cFlag == true
		Parser parser = new Parser();
		boolean cFlag = true;
		Node node = new Node();
		parser.MakeCodeBlock(node, cFlag);
		
		String node_name = node.nodes.get(0).getClass().getSimpleName();
		//boolean flag = node.nodes.get(0).tag;
		// System.out.println(node_name);
		boolean check = node_name.equals("CodeBlock");
		assertEquals(true, check);

		// case : cFlag == false

	}

	// just open case
	@Test
	public void MakeParagraphTest(){
		Parser parser = new Parser();
		Node node = new Node();
		String line = "plain text";
		boolean pFlag = true;

		parser.MakeParagraph(node, line, pFlag);

		String node_name = node.nodes.get(0).getClass().getSimpleName();
		// System.out.println(node_name);
		boolean check = node_name.equals("Paragraph");
		assertEquals(true, check);

		// case : pFlag == false
	}

	// end - BlockQuotes
	@Test
	public void MakeBlockQuotesTest(){
		Parser parser = new Parser();
		Node node = new Node();
		String line ="> start blockquote";
		int bqlevel = 2;

		parser.MakeBlockQuotes(node, line, bqlevel);

		String node_name = node.nodes.get(0).getClass().getSimpleName();
		// System.out.println(node_name);
		boolean check = node_name.equals("BlockQuotes");
		assertEquals(true, check);
	}

	@Test
	public void EndBlockQuotesTest(){
		Parser parser = new Parser();
		Node node = new Node();
		int bqcount = 3;

		parser.EndBlockQuotes(node, bqcount);

		String node_name = node.nodes.get(0).getClass().getSimpleName();
		// System.out.println(node_name +"end");
		boolean check = node_name.equals("BlockQuotes");
		assertEquals(true, check);
	}
/*	
	// state / type / level too many cases...
	@Test
	public void MakeListTest(){
		Parser parser = new Parser();
		Node node = new Node();

		// Unordered List

		// state : 1 for increase, -1 for decrease, 0 for current level
		int state;
		String line = "* hello"
		// type : 1 for ul, 
		ArrayList<Integer> type = new ArrayList<Integer>;
		parser.MakeList(Node node, String line, int state, ArrayList<Integer> type);


		// Ordered List
	}
*/	
	// Token completed
	@Test
	public void MakeStyleTest(){
		Parser parser = new Parser();

		// case_1
		String str1 = "**test1**hey";

		Token token1 = new Token();
		token1.tempStr = str1;
		Parser.MakeStyle(token1);

		String tok;
		boolean check;
		for(int i=0; i<token1.tokens.size(); i++){
			tok = token1.tokens.get(i).getClass().getSimpleName();

			// just Style and Text token exist
			if(!tok.equals("Style")){
				assertEquals(true, tok.equals("Text"));
			}			

		}


		// case_2
		String str2 = "hey*test2*hey";

		Token token2 = new Token();
		token2.tempStr = str2;
		Parser.MakeStyle(token2);

		String tok2;
		boolean check2;
		for(int i=0; i<token2.tokens.size(); i++){
			tok = token2.tokens.get(i).getClass().getSimpleName();

			// just Style and Text token exist
			if(!tok.equals("Style")){
				assertEquals(true, tok.equals("Text"));
			}			

		}


		// case_3
		String str3 = "__test3__test";

		Token token3 = new Token();
		token3.tempStr = str3;
		Parser.MakeStyle(token3);

		String tok3;
		boolean check3;
		for(int i=0; i<token3.tokens.size(); i++){
			tok = token3.tokens.get(i).getClass().getSimpleName();

			// just Style and Text token exist
			if(!tok.equals("Style")){
				assertEquals(true, tok.equals("Text"));
			}			

		}


		// case_4
		String str4 = "_test4_hey";

		Token token4 = new Token();
		token4.tempStr = str4;
		Parser.MakeStyle(token4);

		String tok4;
		boolean check4;
		for(int i=0; i<token4.tokens.size(); i++){
			tok = token4.tokens.get(i).getClass().getSimpleName();

			// just Style and Text token exist
			if(!tok.equals("Style")){
				assertEquals(true, tok.equals("Text"));
			}			

		}

		// case_5 ; No Style tag 
		String str5 = "plaintext";

		Token token5 = new Token();
		token5.tempStr = str5;
		Parser.MakeStyle(token5);

		String tok5;
		boolean check5;
		for(int i=0; i<token5.tokens.size(); i++){
			tok = token5.tokens.get(i).getClass().getSimpleName();

			// justText token exist
			assertEquals(true, tok.equals("Text"));			

		}

	}

	@Test
	public void MakeLinkTest(){
		Parser parser = new Parser();

		// case_1 : make Link tag
		Token token = new Token();
		token.tempStr = "[GitHub](http://github.com)";
		Parser.MakeLink(token);

		String tok = "temp";
		if(token.tokens.size() != 0 )
			tok = token.tokens.get(0).getClass().getSimpleName();

		assertEquals(true, tok.equals("Link"));

		// case_2 : wrong case
		Token token2 = new Token();
		token2.tempStr = "[wrong](https://haein.png)";
		Parser.MakeImg(token2);

		String tok2 = "temp";
		if(token2.tokens.size() != 0)
			tok2 = token2.tokens.get(0).getClass().getSimpleName();

		assertEquals(false, tok2.equals("Link"));

	}

	@Test
	public void MakeImgTest(){
		Parser parser = new Parser();

		// case_1 : make Image tag
		Token token = new Token();
		token.tempStr = "![Image of Yaktocat](http://octodex.github.com/images/yaktocat.png)";
		Parser.MakeImg(token);

		String tok = "temp";
		if(token.tokens.size() != 0 )
			tok = token.tokens.get(0).getClass().getSimpleName();

		assertEquals(true, tok.equals("Image"));

		// case_2 : wrong case
		Token token2 = new Token();
		token2.tempStr = "![git](https://haein.png)";
		Parser.MakeImg(token2);

		String tok2 = "temp";
		if(token2.tokens.size() != 0)
			tok2 = token2.tokens.get(0).getClass().getSimpleName();

		assertEquals(false, tok2.equals("Image"));

	}

	@Test
	public void MakeTextTest(){
		Parser parser = new Parser();
		Token token = new Token();

		Parser.MakeText(token);

		String tok = token.tokens.get(0).getClass().getSimpleName();

		assertEquals(true, tok.equals("Text"));

	}


}
