//package team;
//package dayoul;
//package team.codeGenerator;
//package team;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.w3c.tidy.Tidy;



public class CodeGenerator {

	public CLI cli = new CLI();
	public static boolean isBegin = true;
	public static int lineComp=0;
	public static boolean plainText = true;
	public static boolean nodeOpen;

	public static String msg;
	public static BufferedWriter file;



	CodeGenerator()	{}

	CodeGenerator(CLI cli)
	{
		this.cli = cli;
	}

	public void setNode(Node node,int index, int lineNo, int nodeNo)
	{

	        try
	            {
	            	 file = new BufferedWriter(new FileWriter(CLI.output[index], true));
	            	if(lineNo == 0 && isBegin )
	            	{
	            		isBegin = false;
	            		msg = "<html>\n";
	            		msg += "<head>\n";
	            		msg += "</head>\n";
	            		msg += "<body>\n";
	            	}


	        		if(lineComp < lineNo) // Changing lines
	        		{
	        			msg += "\n";
	        			lineComp = lineNo;
	        		}


	        		if(node.getClass().getSimpleName().equals("Header"))
	        		{


	        			Header header = (Header)node;

	        			if(header.tag)
	        			{
	        				nodeOpen = true;
	        			switch(header.headerNum)
	        			{
	        			case 1: msg += "<h1>";
	        			break;
	        			case 2: msg += "<h2>";
	        			break;
	        			case 3: msg += "<h3>";
	        			break;
	        			case 4: msg += "<h4>";
	        			break;
	        			case 5: msg += "<h5>";
	        			break;
	        			case 6: msg += "<h6>";
	        			break;
	        			}
	        			}
	        			else
	        			{
	        				nodeOpen = false;
	        				switch(header.headerNum)
		        			{
		        			case 1: msg += "</h1>";
		        			break;
		        			case 2: msg += "</h2>";
		        			break;
		        			case 3: msg += "</h3>";
		        			break;
		        			case 4: msg += "</h4>";
		        			break;
		        			case 5: msg += "</h5>";
		        			break;
		        			case 6: msg += "</h6>";
		        			break;
		        			}
	        			}

	        		}


	        		if(node.getClass().getSimpleName().equals("Paragraph"))
	        		{
	        			Paragraph paragraph = (Paragraph)node;

	        			if(paragraph.tag)
	        			{
	        				nodeOpen = true;
	        				msg += "<p>\n";
	        			}
	        			else
	        			{
	        				nodeOpen = false;
	        				msg += "</p>\n";
	        			}

	        		}

	        		if(node.getClass().getSimpleName().equals("CodeBlock"))
	        		{
	        			CodeBlock codeBlock = (CodeBlock)node;

	        			if(codeBlock.tag)
	        			{
	        				nodeOpen = true;
	        				msg += "<code>";
	        			}
	        			else
	        			{
	        				nodeOpen = false;
	        				msg += "</code>";
	        			}

	        		}

	        		if(node.getClass().getSimpleName().equals("List"))
	        		{
	        			List list = (List)node;

	        			if(list.ol == 1)
	        			{
	        				nodeOpen = true;
	        				msg += "<ol>\n";
	        			}
	        			if(list.ul == 1)
	        			{
	        				nodeOpen = true;
	        				msg += "<ul>\n";
	        			}
	        			if(list.li == 1)
	        			{
	        				nodeOpen = true;
	        				msg += "<li>";
	        			}
	        			if(list.ol == -1)
	        			{
	        				nodeOpen = false;
	        				msg += "</ol>\n";
	        			}
	        			if(list.ul == -1)
	        			{
	        				nodeOpen = false;
	        				msg += "</ul>\n";
	        			}
	        			if(list.li == -1)
	        			{
	        				nodeOpen = false;
	        				msg += "</li>";
	        			}



	        		}

	        		if(node.getClass().getSimpleName().equals("BlockQuotes"))
	        		{
	        			BlockQuotes blockQuotes = (BlockQuotes)node;

	        			if(blockQuotes.tag)
	        			{
	        				nodeOpen = true;
	        				msg += "<blockquote>\n";
	        			}
	        			else
	        			{
	        				nodeOpen = false;
	        				msg += "</blockquote>";
	        			}
	        		}



	          		if(node.getClass().getSimpleName().equals("HorizontalBar"))
	          		{
	          			msg += "<hr>";
	          		}

	           	 if((lineComp  == (Main.docs[index]).docNodes.size()-1) && !nodeOpen)
	    		 {
	    		 try{
	    		 if(((Main.docs[index]).docNodes.get(lineNo)).
	    				 nodes.get(nodeNo+1) == null)
	         	{}
    		        }

	    		 catch (Exception e)
	    		 {
	    			    msg += "\n</body>";
	    	    		msg +="\n</html>";
	    		 }

	    		 }




	            }
	            catch (IOException e)
	            {
	                System.err.println(e);
	                System.exit(1);
	            }
	            catch (Exception e){
	                System.out.println(e);
	            }


	}

	public void setNode(Node node,int index, int lineNo,int nodeNo,String color)
	{
		  try
          {
          	 file = new BufferedWriter(new FileWriter(CLI.output[index], true));
          	if(lineNo == 0 && isBegin )
          	{
          		isBegin = false;
          		msg = "<html>\n";
        		msg += "<head>\n";
        		msg += "<style type = \"text/css\">\n";
        		msg += "h1 {color:" + color + "}\n";
        		msg += "</style>\n";
        		msg += "</head>\n";
        		msg += "<body>\n";
          	}


      		if(lineComp < lineNo) //???? (????)
      		{
      			msg += "\n";
      			lineComp = lineNo;
      		}


      		if(node.getClass().getSimpleName().equals("Header")) //??
      		{


      			Header header = (Header)node;

      			if(header.tag)
      			{
      				nodeOpen = true;
      			switch(header.headerNum)
      			{
      			case 1: msg += "<h1>";
      			break;
      			case 2: msg += "<h2>";
      			break;
      			case 3: msg += "<h3>";
      			break;
      			case 4: msg += "<h4>";
      			break;
      			case 5: msg += "<h5>";
      			break;
      			case 6: msg += "<h6>";
      			break;
      			}
      			}
      			else
      			{
      				nodeOpen = false;
      				switch(header.headerNum)
	        			{
	        			case 1: msg += "</h1>";
	        			break;
	        			case 2: msg += "</h2>";
	        			break;
	        			case 3: msg += "</h3>";
	        			break;
	        			case 4: msg += "</h4>";
	        			break;
	        			case 5: msg += "</h5>";
	        			break;
	        			case 6: msg += "</h6>";
	        			break;
	        			}
      			}

      		}




         	 if((lineComp  == (Main.docs[index]).docNodes.size()-1) && !nodeOpen)
  		 {
  		 try{
  		 if(((Main.docs[index]).docNodes.get(lineNo)).
  				 nodes.get(nodeNo+1) == null)
       	{}
		        }

  		 catch (Exception e)
  		 {
  			    msg += "\n</body>";
  	    		msg +="\n</html>";
  		 }

  		 }




          }
          catch (IOException e)
          {
              System.err.println(e);
              System.exit(1);
          }
          catch (Exception e){
              System.out.println(e);
          }

	}


	public void setToken(Token token,int index, int lineNo, int nodeNo, int tokenNo)
	{

		 try
         {
		 file = new BufferedWriter(new FileWriter(CLI.output[index], true));

			if(isBegin)
			{

				isBegin = false;
				msg = "<html>\n";
        		msg += "<head>\n";
        		msg += "</head>\n";
        		msg += "<body>\n";
			}

			if(lineComp < lineNo) //???? (????)
    		{
    			msg += "\n";
    			lineComp = lineNo;
    		}

		 if(token.getClass().getSimpleName().equals("Text"))
		 {
			Text text = (Text)token;

			msg += text.text;
		 }

		 if(token.getClass().getSimpleName().equals("Style"))
		 {
			 Style style = (Style)token;
			 if(style.category.equals("_") || style.category.equals("*"))
			 {
				 if(style.tag)
				 {
					 msg += "<em>";
				 }
					 else
					 {
						msg += "</em>";
					 }
				}

			 else if(style.category.equals("__") || style.category.equals("**"))
			 {
				 if(style.tag)
				 {
					 msg += "<strong>";
				 }
					 else
					 {
					 msg += "</strong>";
					 }
			 }
		 }

		 if(token.getClass().getSimpleName().equals("Link"))
		 {
			 Link link = (Link)token;

			 if(link.tag)
			 {
				 msg += "<a href = " + link.href +">";
				 msg += link.linkName;
			 }
			 else
			 {
				 msg += "</a>";
			 }
		 }

		 if(token.getClass().getSimpleName().equals("Image"))
		 {

			 Image image = (Image)token;

				 msg += "<img src=" + image.src +" alt= "+image.altText + ">";

		 }

		 if((lineComp  == (Main.docs[index]).docNodes.size()-1) && !nodeOpen)
		 {
		 try{
		 if(((Main.docs[index]).docNodes.get(lineNo)).
				 nodes.get(nodeNo).token.tokens.get(tokenNo+1) == null)
     	{}
		 }

		 catch (Exception e)
		 {
			 msg += "\n</body>";
	    	 msg +="\n</html>";
		 }
		 }

         }

		  catch (IOException e)
         {
             System.err.println(e);
             System.exit(1);
         }
         catch (Exception e){
             System.out.println(e);
         }



	}



	public void setToken(Token token,int index, int lineNo, int nodeNo, int tokenNo, String color)
	{
		 try
         {
		 file = new BufferedWriter(new FileWriter(CLI.output[index], true));

			if(isBegin )
			{
				isBegin = false;
				msg = "<html>\n";
        		msg += "<head>\n";
        		msg += "<style type = \"text/css\">\n";
        		msg += "h1 {color:" + color + "}\n";
        		msg += "</style>\n";
        		msg += "</head>\n";
        		msg += "<body>\n";
			}

			if(lineComp < lineNo) //???? (????)
    		{
    			msg += "\n";
    			lineComp = lineNo;
    		}

		 if(token.getClass().getSimpleName().equals("Text"))
		 {
			Text text = (Text)token;

			msg += text.text;
		 }

		 if(token.getClass().getSimpleName().equals("Style"))
		 {

			 Style style = (Style)token;
			 if(style.category.equals("_") || style.category.equals("'*'"))
			 {
				 if(style.tag)
				 {
					 msg += "<em>";
				 }
					 else
					 {
						msg += "</em>";
					 }
				}

			 else if(style.category.equals("__")|| style.category.equals("'**'"))
			 {
				 if(style.tag)
				 {
					 msg += "<strong>";
				 }
					 else
					 {
					 msg += "</strong>";
					 }
			 }
		 }



		 if((lineComp  == (Main.docs[index]).docNodes.size()-1) && !nodeOpen)
		 {
		 try{
		 if(((Main.docs[index]).docNodes.get(lineNo)).
				 nodes.get(nodeNo).token.tokens.get(tokenNo+1) == null)
     	{}
		 }

		 catch (Exception e)
		 {
			 msg += "\n</body>";
	    	 msg +="\n</html>";
		 }
		 }

         }

		  catch (IOException e)
         {
             System.err.println(e);
             System.exit(1);
         }
         catch (Exception e){
             System.out.println(e);
         }


}
}
