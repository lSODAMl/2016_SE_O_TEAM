//package TEST;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.*;

//import CLI.*;
//import IR.*;
//import PARSER.*;
//import CODEGEN.*;
public class CodeGeneratorTest {
	public static CLI cli = new CLI();

	@Test 
	public void setNode1Test(){
		
		CodeGenerator codeGen= new CodeGenerator();
		
		Node node = new Node();
		
			Header node_h1 = new Header();
			node_h1.line = "# h1";	
			node_h1.tag=true;
			node_h1.headerNum=1;
			codeGen.setNode(node, 0, 0, 0);
			node_h1.tag=false;
			codeGen.setNode(node, 0, 0, 0);

			Header node_h2 = new Header();
			node_h2.line = "## h2";
			node_h2.tag=true;
			node_h2.headerNum=2;
			codeGen.setNode(node_h2, 1, 1, 1);
			node_h2.tag=false;
			codeGen.setNode(node_h2, 1, 1, 1);
			
			Header node_h3 = new Header();
			node_h3.line = "### h3";
			node_h3.tag=true;
			node_h3.headerNum=3;
			codeGen.setNode(node_h3, 1, 2, 3);
			node_h3.tag=false;
			codeGen.setNode(node_h3, 1, 2, 3);

			Header node_h4 = new Header();
			node_h4.line = "#### h4";
			node_h4.headerNum=4;
			node_h4.tag=true;
			codeGen.setNode(node_h4, 3, 2, 1);
			node_h4.tag=false;
			codeGen.setNode(node_h4, 1, 2, 3);
			
			Header node_h5 = new Header();
			node_h5.line = "##### h5";
			node_h5.headerNum=5;
			node_h5.tag=true;
			codeGen.setNode(node_h5, 1, 3, 2);
			node_h5.tag=false;
			codeGen.setNode(node_h5, 1, 3, 2);
			
			Header node_h6 = new Header();
			node_h6.line = "###### h6";
			node_h6.headerNum=6;
			node_h6.tag=true;
			codeGen.setNode(node_h6, 2, 3, 1);
			node_h6.tag=false;
			codeGen.setNode(node_h6, 2, 3, 1);
			
			//Para
			Paragraph node_p = new Paragraph();
			node_p.line="para";
			node_p.tag=true;
			codeGen.setNode(node_p, 3, 3, 1);
			node_p.tag=false;
			codeGen.setNode(node_p, 3, 3, 1);

			BlockQuotes node_bq = new BlockQuotes();
			node_bq.line = "> block quotes";
			node_bq.tag = true; 
			codeGen.setNode(node_bq, 1, 1, 2);
			node_bq.tag = false; 
			codeGen.setNode(node_bq, 1, 1, 2);

			List node_li1 = new List();
			List node_li2 = new List();
			node_li1.ol = 1;
			node_li1.ul = 1;
			node_li1.li = 1;
			node_li1.line = "somelist";
			codeGen.setNode(node_li1, 3, 3, 1);
			node_li2.ol = -1;
			node_li2.ul = -1;
			node_li2.li = -1;
			node_li2.line = "somelist";
			codeGen.setNode(node_li2, 2, 1, 1);
			
			
			HorizontalBar node_hb = new HorizontalBar();
			node_hb.line = "--------";
			codeGen.setNode(node_hb, 4, 1, 1);
			
					
		assertEquals(true, node.nodes.get(0).getClass().getSimpleName().equals("Header"));

		
    }
	@Test 
	public void setNode2Test(){
		
		CodeGenerator codeGen= new CodeGenerator();
		
		Node node = new Node();
			Header node_h1 = new Header();
			node_h1.line = "# h1";	
			node_h1.tag=true;
			node_h1.headerNum=1;
			node.nodes.add(node_h1);
			codeGen.setNode(node, 0, 0, 0,"Green");
			node_h1.tag=false;
			codeGen.setNode(node, 0, 0, 0,"Green");

			Header node_h2 = new Header();
			node_h2.line = "## h2";
			node_h2.tag=true;
			node_h2.headerNum=2;
			node.nodes.add(node_h2);
			codeGen.setNode(node_h2, 1, 1, 1,"Green");
			node_h2.tag=false;
			codeGen.setNode(node_h2, 1, 1, 1,"Green");
			
			Header node_h3 = new Header();
			node_h3.line = "### h3";
			node_h3.tag=true;
			node_h3.headerNum=3;
			node.nodes.add(node_h3);
			codeGen.setNode(node_h3, 1, 2, 3,"Green");
			node_h3.tag=false;
			codeGen.setNode(node_h3, 1, 2, 3,"Green");

			Header node_h4 = new Header();
			node_h4.line = "#### h4";
			node_h4.headerNum=4;
			node_h4.tag=true;
			codeGen.setNode(node_h4, 3, 2, 1, "Blue");
			node_h4.tag=false;
			codeGen.setNode(node_h4, 1, 2, 3, "Blue");
			
			Header node_h5 = new Header();
			node_h5.line = "##### h5";
			node_h5.headerNum=5;
			node_h5.tag=true;
			codeGen.setNode(node_h5, 1, 3, 2, "Blue");
			node_h5.tag=false;
			codeGen.setNode(node_h5, 1, 3, 2, "Blue");
			
			Header node_h6 = new Header();
			node_h6.line = "###### h6";
			node_h6.headerNum=6;
			node_h6.tag=true;
			codeGen.setNode(node_h6, 2, 3, 1, "Blue");
			node_h6.tag=false;
			codeGen.setNode(node_h6, 2, 3, 1, "Blue");
			
			//Para
			Paragraph node_p = new Paragraph();
			node_p.line="para";
			node_p.tag=true;
			codeGen.setNode(node_p, 3, 3, 1, "Red");
			node_p.tag=false;
			codeGen.setNode(node_p, 3, 3, 1, "Red");

			BlockQuotes node_bq = new BlockQuotes();
			node_bq.line = "> block quotes";
			node_bq.tag = true; 
			codeGen.setNode(node_bq, 1, 1, 2, "Red");
			node_bq.tag = false; 
			codeGen.setNode(node_bq, 1, 1, 2, "Red");

			List node_li1 = new List();
			List node_li2 = new List();
			node_li1.ol = 1;
			node_li1.ul = 1;
			node_li1.li = 1;
			node_li1.line = "somelist";
			codeGen.setNode(node_li1, 3, 3, 1, "Red");
			node_li2.ol = -1;
			node_li2.ul = -1;
			node_li2.li = -1;
			node_li2.line = "somelist";
			codeGen.setNode(node_li2, 2, 1, 1, "Red");
			
			
			HorizontalBar node_hb = new HorizontalBar();
			node_hb.line = "--------";
			codeGen.setNode(node_hb, 4, 1, 1, "Red");
			
		assertEquals(false, node.nodes.get(0).getClass().getSimpleName().equals("Header"));

		
    }

	
	
	@Test
	public void setToken1Test(){
		CodeGenerator codeGen= new CodeGenerator();
		
		Token tok = new Token();
	
			Text tok_text = new Text("text");
			tok_text.tempStr="text";
			codeGen.setToken(tok_text, 0, 0, 0, 0);

			Style tok_style1 = new Style("__style__", true);
			tok_style1.tempStr="__style__";
			tok_style1.category="__";
			tok_style1.tag = true;
			codeGen.setToken(tok_style1, 1, 2, 3, 4);
			tok_style1.tag = false;
			codeGen.setToken(tok_style1, 1, 2, 3, 4);

			Style tok_style2 = new Style("_style_", true);
			tok_style2.tempStr="_style_";
			tok_style2.category="_";
			tok_style2.tag=true;
			codeGen.setToken(tok_style2, 1, 2, 3, 4);
			Style tok_style3 = new Style("yle_", false);
			tok_style2.tag=false;
			codeGen.setToken(tok_style2, 1, 2, 3, 4);

			tok_style3.tempStr="yle_";
			codeGen.setToken(tok_style3, 1, 2, 3, 4);

			
			
			Link tok_link = new Link();
			tok_link.linkName="naver";
			tok_link.href="http:\\www.naver.com";
			tok_link.tag = true;
			codeGen.setToken(tok_link, 4, 3, 2, 1);
			tok_link.tag = false;
			codeGen.setToken(tok_link, 4, 3, 2, 1);
			
			Image tok_image = new Image();
			tok_image.altText="alt";
			tok_image.src="http:\\somewhatsrc";
			codeGen.setToken(tok_image, 2, 1, 5, 3);
	
	}
	@Test
	public void setToken2Test(){
		CodeGenerator codeGen= new CodeGenerator();
		
		Token tok = new Token();
	
			Text tok_text = new Text("text");
			tok_text.tempStr="text";
			codeGen.setToken(tok_text, 0, 0, 0, 0, "Red");

			Style tok_style1 = new Style("__style__", true);
			tok_style1.tempStr="__style__";
			tok_style1.category="__";
			tok_style1.tag = true;
			codeGen.setToken(tok_style1, 1, 2, 3, 4, "Red");
			tok_style1.tag = false;
			codeGen.setToken(tok_style1, 1, 2, 3, 4, "Red");

			Style tok_style2 = new Style("_style_", true);
			tok_style2.tempStr="_style_";
			tok_style2.category="_";
			tok_style2.tag=true;
			codeGen.setToken(tok_style2, 1, 2, 3, 4, "Red");
			Style tok_style3 = new Style("yle_", false);
			tok_style2.tag=false;
			codeGen.setToken(tok_style2, 1, 2, 3, 4, "Red");

			tok_style3.tempStr="yle_";
			codeGen.setToken(tok_style3, 1, 2, 3, 4, "Red");

			
			
			Link tok_link = new Link();
			tok_link.linkName="naver";
			tok_link.href="http:\\www.naver.com";
			tok_link.tag = true;
			codeGen.setToken(tok_link, 4, 3, 2, 1, "Red");
			tok_link.tag = false;
			codeGen.setToken(tok_link, 4, 3, 2, 1, "Red");
			
			Image tok_image = new Image();
			tok_image.altText="alt";
			tok_image.src="http:\\somewhatsrc";
			codeGen.setToken(tok_image, 2, 1, 5, 3, "Red");
	}

}
