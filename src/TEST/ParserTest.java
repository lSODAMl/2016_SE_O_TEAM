//package TEST;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class ParserTest {
/*
	@Test
	public void docParserTest(){
		// directory -> file -> ioException
		Parser parser = new Parser();
		String fileName = "a.md";
		Document doc = new Document();

		parser.docParser(fileName, doc);




	}

	@Test
	public void nodeParserTest(){
		// blockquotes -> codeblock -> list
		// header -> hr bar -> paragraph
		Parser parser = new Parser();
		Node node = new Node();


	}
*/
	@Test
	public void tokenParserTest(){
		// img -> link -> style -> text

		Parser parser = new Parser();

		// img case
		Node node_img = new Node();
		node_img.token.tempStr = "![Image of Yaktocat](http://octodex.github.com/images/yaktocat.png)";
		String str1 = node_img.token.tempStr;
		
		parser.tokenParser(node_img);
		//System.out.println("size" + node_img.token.tokens.size());
		assertEquals(true, node_img.token.tokens.get(0).getClass().getSimpleName().equals("Image"));
		//System.out.println(node_img.token.tokens.get(i).getClass().getSimpleName());


		// link case
		Node node_link = new Node();
		node_link.token.tempStr = "[GitHub](http://github.com)";
		String str2 = node_link.token.tempStr;

		parser.tokenParser(node_link);
		assertEquals(true, node_link.token.tokens.get(0).getClass().getSimpleName().equals("Link"));


		// style case
		Node node_style = new Node();
		node_style.token.tempStr = "software engineering is ** interesting **";
		String str3 = node_style.token.tempStr;

		parser.tokenParser(node_style);

		boolean check = false;
		for( int i = 0; i< node_style.token.tokens.size(); i++){
			check = node_style.token.tokens.get(i).getClass().getSimpleName().equals("Style");
			// System.out.println(node_style.token.tokens.get(i).getClass().getSimpleName() +" - " + check);

			if( check == true ){
				assertEquals(true, node_style.token.tokens.get(i).getClass().getSimpleName().equals("Style"));

			}else{
				assertEquals(true, node_style.token.tokens.get(i).getClass().getSimpleName().equals("Text"));
			}
		}


		// text case
		Node node_text = new Node();
		node_text.token.tempStr = "text text text";
		String str4 = node_text.token.tempStr;

		parser.tokenParser(node_text);

		String check2 = "temp";
		for(int i=0; i<node_text.token.tokens.size(); i++){
			assertEquals(true, node_style.token.tokens.get(i).getClass().getSimpleName().equals("Text"));
		}

	}

	@Test
	public void MakeHeaderTest() {

		Parser parser = new Parser();

		String str = "#### h4";
		Node node = new Node();
		parser.MakeHeader(node , str);

		// check <header>
		String node_start = node.nodes.get(0).getClass().getSimpleName();
		boolean check = node_start.equals("Header");
		assertEquals(true, check);

 		// check </header>
		String node_end = node.nodes.get(node.nodes.size()-1).getClass().getSimpleName();
		boolean check2 = node_end.equals("Header");
		assertEquals(true, check2);

	}

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

	@Test
	public void MakeCodeBlockTest(){

		Parser parser = new Parser();

		// case1 : <codeblock>
		boolean cFlag = false;
		Node node = new Node();
		parser.MakeCodeBlock(node, cFlag);
		
		String node_start = node.nodes.get(0).getClass().getSimpleName();
		//boolean flag = node.nodes.get(0).tag;
		// System.out.println(node_name);
		boolean check = node_start.equals("CodeBlock");
		assertEquals(true, check);

		// case : </codeblock>
		boolean cFlag2 = false;
		Node node2 = new Node();
		parser.MakeCodeBlock(node2, cFlag2);

		String node_end = node.nodes.get(0).getClass().getSimpleName();
		boolean check2 = node_end.equals("CodeBlock");
		assertEquals(true,check2);

	}


	// have to do
	@Test
	public void MakeParagraphTest(){
		Parser parser = new Parser();

		// case_1 : <p> tag
		Node node = new Node();
		String line = "plain text";
		boolean pFlag = true;

		parser.MakeParagraph(node, line, pFlag);

		String node_name = node.nodes.get(0).getClass().getSimpleName();
		//System.out.println(node_name);
		boolean check = node_name.equals("Paragraph");
		assertEquals(true, check);

/*		
		// case_2 : pFlag == false , in the <p> tag
		Node node2 = new Node();
		String line2 = "in the paragraph";
		boolean pFlag2 = false;

		parser.MakeParagraph(node2, line2, pFlag2);

		String node_in = node2.nodes.get(0).getClass().getSimpleName();
		System.out.println(node_in);
		boolean check2 = node_in.equals("Paragraph");
		assertEquals(false, check2);
		*/
	}

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
