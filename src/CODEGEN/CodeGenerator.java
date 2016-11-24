//package team;
//package dayoul;
//package team.codeGenerator;
//package team;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.w3c.tidy.Tidy;



public class CodeGenerator {

	private CLI cli = new CLI();
	private static boolean isBegin = true;
	private static int lineComp=0;
	private static int inLine=0;
	private static String tempTag[] = new String[10];
	private static int tagIndex = 0;
	private static boolean tokBefore;
	private static boolean isOpen[] = new boolean[10];//�ߺ� ��Ÿ�� �±� �ݴ°� ����.
	private static int styleTagIndex = 0;
	private static int tokSize=0;
	private static boolean plainText = true;

	public static String msg;
	public static BufferedWriter file;

	Tidy tidy = new Tidy();

	CodeGenerator()	{}

	CodeGenerator(CLI cli)
	{
		this.cli = cli;
	}

	public void selector()
	{

	}

	public void setNode(Node node,int index, int lineNo)
	{
		//System.out.println(cli.output[index]);
		tokBefore = false;

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


	        		if(lineComp < lineNo) //�ٹٲ��� (�ؽ�Ʈ��)
	        		{
	        			msg += "\n";
	        			lineComp = lineNo;
	        			inLine=0;
	        			tokSize = ((Main.docs[index]).docNodes.get(lineNo)).nodes.size();
	        		}


	        		if(node.getClass().getSimpleName().equals("Header")) //����
	        		{
	        			//plainText = false;

	        			Header header = (Header)node;
	        			switch(header.headerNum)
	        			{
	        			case 1: msg += "<h1>";
	        			tempTag[tagIndex] = "</h1>";
	        			break;
	        			case 2: msg += "<h2>";
	        			tempTag[tagIndex] = "</h2>";
	        			break;
	        			case 3: msg += "<h3>";
	        			tempTag[tagIndex] = "</h3>";
	        			break;
	        			case 4: msg += "<h4>";
	        			tempTag[tagIndex] = "</h4>";
	        			break;
	        			case 5: msg += "<h5>";
	        			tempTag[tagIndex] = "</h5>";
	        			break;
	        			case 6: msg += "<h6>";
	        			tempTag[tagIndex] = "</h6>";
	        			break;
	        			}
	        			tagIndex++;
	        		}

	        		//System.out.println("Node inLine " + inLine);
	    	    	//System.out.println("Node�� ��ġ " + ((Main.docs[index]).docNodes.get(lineNo)).nodes.size());

	        		if(inLine == ((Main.docs[index]).docNodes.get(lineNo)).nodes.size()-1)
	    	    	{
	        			//System.out.println("����ݾ�");
	    				for(int i=0;i<tagIndex;i++)
	    				{
	    					//System.out.println("����ݾ�");
	    					msg += tempTag[i];
	    					 // �ݴ� �ױ� �߰�
	    				}

	    				tagIndex = 0; //�ʱ�ȭ
	    	    	}

	        		//System.out.println("lineComp " + lineComp);
	        		//System.out.println("Main.docs " + (Main.docs[index].docNodes.size()-1));
	        		//System.out.println("inLine " + inLine);
	        		//System.out.println("Main.docs.line�� ��ġ " + ((Main.docs[index]).docNodes.get(lineNo)).nodes.size());
	            	if((lineComp  == (Main.docs[index]).docNodes.size()-1)&&
	            			(inLine == ((Main.docs[index]).docNodes.get(lineNo)).nodes.size()-1)&& !isOpen[styleTagIndex])
	            	{
	            		msg += "\n</body>";
	            		msg +="\n</html>";

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

	        inLine++;
	}

	public void setNode(Node node,int index, int lineNo,String color)
	{
		//System.out.println(cli.output[index]);
		tokBefore = false;

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


	        		if(lineComp < lineNo) //�ٹٲ��� (�ؽ�Ʈ��)
	        		{
	        			msg += "\n";
	        			lineComp = lineNo;
	        			inLine=0;
	        			tokSize = ((Main.docs[index]).docNodes.get(lineNo)).nodes.size();
	        		}


	        		if(node.getClass().getSimpleName().equals("Header")) //����
	        		{
	        			//plainText = false;

	        			Header header = (Header)node;
	        			switch(header.headerNum)
	        			{
	        			case 1: msg += "<h1>";
	        			tempTag[tagIndex] = "</h1>";
	        			break;
	        			case 2: msg += "<h2>";
	        			tempTag[tagIndex] = "</h2>";
	        			break;
	        			case 3: msg += "<h3>";
	        			tempTag[tagIndex] = "</h3>";
	        			break;
	        			case 4: msg += "<h4>";
	        			tempTag[tagIndex] = "</h4>";
	        			break;
	        			case 5: msg += "<h5>";
	        			tempTag[tagIndex] = "</h5>";
	        			break;
	        			case 6: msg += "<h6>";
	        			tempTag[tagIndex] = "</h6>";
	        			break;
	        			}
	        			tagIndex++;
	        		}

	        		//.println("Node inLine " + inLine);
	    	    	//System.out.println("Node�� ��ġ " + ((Main.docs[index]).docNodes.get(lineNo)).nodes.size());

	        		if(inLine == ((Main.docs[index]).docNodes.get(lineNo)).nodes.size()-1)
	    	    	{
	        			//System.out.println("����ݾ�");
	    				for(int i=0;i<tagIndex;i++)
	    				{
	    					//System.out.println("����ݾ�");
	    					msg += tempTag[i];
	    					 // �ݴ� �ױ� �߰�
	    				}

	    				tagIndex = 0; //�ʱ�ȭ
	    	    	}

	        		//System.out.println("lineComp " + lineComp);
	        		//System.out.println("Main.docs " + (Main.docs[index].docNodes.size()-1));
	        		//System.out.println("inLine " + inLine);
	        		//System.out.println("Main.docs.line�� ��ġ " + ((Main.docs[index]).docNodes.get(lineNo)).nodes.size());
	            	if((lineComp  == (Main.docs[index]).docNodes.size()-1)&&
	            			(inLine == ((Main.docs[index]).docNodes.get(lineNo)).nodes.size()-1)&& !isOpen[styleTagIndex])
	            	{
	            		msg += "\n</body>";
	            		msg +="\n</html>";

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

	        inLine++;
	}


	public void setToken(Token token,int index, int lineNo, int nodeNo, int tokenNo)
	{
		if(tokSize==0) //token�� ����� �޴� ���̴�.
			tokSize = ((Main.docs[index]).docNodes.get(lineNo)).nodes.size();

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

			if(lineComp < lineNo) //�ٹٲ��� (�ؽ�Ʈ��)
    		{
				System.out.println("�ٹٲ�!");
    			msg += "\n";
    			lineComp = lineNo;
    			inLine=0;
    			tokSize = ((Main.docs[index]).docNodes.get(lineNo)).nodes.size();
    		}

		 if(token.getClass().getSimpleName().equals("Text"))
		 {
			Text text = (Text)token;
			//System.out.println("����"+text.text);

			msg += text.text;

			 try{

				 if(((Main.docs[index]).docNodes.get(lineNo)).
						 nodes.get(nodeNo).token.tokens.get(tokenNo+1) != null&&!tokBefore){
							 tokSize++;
						 }
			 }
				  catch (Exception e)
		         {
						for(int i=0;i<tagIndex;i++) //header �� �� �±� ���Ժκ�
						{
							msg += tempTag[i];
								 // �ݴ� �ױ� �߰�
						}
						tagIndex = 0;
		            // System.err.println(e);
		         }

			 if(!tokBefore)
				 inLine++;
		 }

		 if(token.getClass().getSimpleName().equals("Style"))
		 {
			 Style style = (Style)token;
			 if(style.category.equals("_"))
			 {
				 if(style.tag)
				 {
					// System.out.println("����"+style.category);
					 if(!tokBefore)
						  inLine++;
					 tokBefore = false;
					 if(styleTagIndex>0)
						 styleTagIndex++;

					 msg += "<em>";
					 isOpen[styleTagIndex] = true;

				 }
					 else
					 {  // System.out.println("em��");
					// System.out.println("����"+style.category);

					 try{

					 if(((Main.docs[index]).docNodes.get(lineNo)).
							 nodes.get(nodeNo).token.tokens.get(tokenNo+1) != null)
					 {
						 tokSize++;
					 }

					 }
					  catch (Exception e)
			         {

			            // System.err.println(e);
			         }


					 isOpen[styleTagIndex] = false;
					 if(styleTagIndex>0)
						 styleTagIndex--;
					 msg += "</em>";
					 }
				}

			 else if(style.category.equals("__"))
			 {
				 if(style.tag)
				 {
					// System.out.println("����"+style.category);
					 if(!tokBefore)
						  inLine++;
					 tokBefore = false;
					 if(styleTagIndex>0)
						 styleTagIndex++;

					 msg += "<strong>";
					 isOpen[styleTagIndex] = true;

				 }
					 else
					 {  // System.out.println("strong��");
					// System.out.println("����"+style.category);

					 try{

					 if(((Main.docs[index]).docNodes.get(lineNo)).
							 nodes.get(nodeNo).token.tokens.get(tokenNo+1) != null)
					 {
						 tokSize++;
					 }

					 }
					  catch (Exception e)
			         {
			           //  System.err.println(e);
			         }


					 isOpen[styleTagIndex] = false;
					 if(styleTagIndex>0)
						 styleTagIndex--;
					 msg += "</strong>";
					 }
			 }
		 }

		  //	System.out.println("Token inLine " + inLine);
	    	//System.out.println("Main.docs.line�� ��ġ " + ((Main.docs[index]).docNodes.get(lineNo)).nodes.size());
		// System.out.println("inLine " + inLine);
 	//	System.out.println("Main.docs.line�� ��ġ " + tokSize);
	    	if(inLine == tokSize && !isOpen[styleTagIndex])
	    	{
	    		tokBefore = false;
	    	//	System.out.println("�ʱ�ȭ");
				for(int i=0;i<tagIndex;i++) //header �� �� �±� ���Ժκ�
				{ //System.out.println("��");
					msg += tempTag[i];
					 // �ݴ� �ױ� �߰�
				}
				if((lineComp  == (Main.docs[index]).docNodes.size()-1)&&
	        			(inLine == tokSize && !isOpen[styleTagIndex]))
	        	{
					//System.out.println("�����±�");
		    		msg += "\n</body>";
	        		msg +="\n</html>";

	        	}
				inLine=0;
				tagIndex = 0; //�ʱ�ȭ

				return;
	    	}
		//	System.out.println("lineComp " + lineComp);
    	//	System.out.println("Main.docs " + (Main.docs[index].docNodes.size()-1));
    		//System.out.println("inLine " + inLine);


         }

		  catch (IOException e)
         {
             System.err.println(e);
             System.exit(1);
         }
         catch (Exception e){
             System.out.println(e);
         }


		 if(isOpen[styleTagIndex])
			 tokBefore = true;
		 else
			 tokBefore = false;

	}

	public void setToken(Token token,int index, int lineNo, int nodeNo, int tokenNo, String color)
	{
		if(tokSize==0) //token�� ����� �޴� ���̴�.
			tokSize = ((Main.docs[index]).docNodes.get(lineNo)).nodes.size();

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

			if(lineComp < lineNo) //�ٹٲ��� (�ؽ�Ʈ��)
    		{
				//System.out.println("�ٹٲ�!");
    			msg += "\n";
    			lineComp = lineNo;
    			inLine=0;
    			tokSize = ((Main.docs[index]).docNodes.get(lineNo)).nodes.size();
    		}

		 if(token.getClass().getSimpleName().equals("Text"))
		 {
			Text text = (Text)token;
			//System.out.println("����"+text.text);

			msg += text.text;

			 try{

				 if(((Main.docs[index]).docNodes.get(lineNo)).
						 nodes.get(nodeNo).token.tokens.get(tokenNo+1) != null&&!tokBefore){
							 tokSize++;
						 }
			 }
				  catch (Exception e)
		         {
						for(int i=0;i<tagIndex;i++) //header �� �� �±� ���Ժκ�
						{
							msg += tempTag[i];
								 // �ݴ� �ױ� �߰�
						}
						tagIndex = 0;
		           //  System.err.println(e);
		         }

			 if(!tokBefore)
				 inLine++;
		 }

		 if(token.getClass().getSimpleName().equals("Style"))
		 {
			 Style style = (Style)token;
			 if(style.category.equals("_"))
			 {
				 if(style.tag)
				 {
					// System.out.println("����"+style.category);
					 if(!tokBefore)
						  inLine++;
					 tokBefore = false;
					 if(styleTagIndex>0)
						 styleTagIndex++;

					 msg += "<em>";
					 isOpen[styleTagIndex] = true;

				 }
					 else
					 { //  System.out.println("em��");
				//	 System.out.println("����"+style.category);

					 try{

					 if(((Main.docs[index]).docNodes.get(lineNo)).
							 nodes.get(nodeNo).token.tokens.get(tokenNo+1) != null)
					 {
						 tokSize++;
					 }

					 }
					  catch (Exception e)
			         {

			            // System.err.println(e);
			         }


					 isOpen[styleTagIndex] = false;
					 if(styleTagIndex>0)
						 styleTagIndex--;
					 msg += "</em>";
					 }
				}

			 else if(style.category.equals("__"))
			 {
				 if(style.tag)
				 {
					// System.out.println("����"+style.category);
					 if(!tokBefore)
						  inLine++;
					 tokBefore = false;
					 if(styleTagIndex>0)
						 styleTagIndex++;

					 msg += "<strong>";
					 isOpen[styleTagIndex] = true;

				 }
					 else
					 {  // System.out.println("strong��");
				// System.out.println("����"+style.category);

					 try{

					 if(((Main.docs[index]).docNodes.get(lineNo)).
							 nodes.get(nodeNo).token.tokens.get(tokenNo+1) != null)
					 {
						 tokSize++;
					 }

					 }
					  catch (Exception e)
			         {
			           //  System.err.println(e);
			         }


					 isOpen[styleTagIndex] = false;
					 if(styleTagIndex>0)
						 styleTagIndex--;
					 msg += "</strong>";
					 }
			 }
		 }

		  //	System.out.println("Token inLine " + inLine);
	    	//System.out.println("Main.docs.line�� ��ġ " + ((Main.docs[index]).docNodes.get(lineNo)).nodes.size());
		// System.out.println("inLine " + inLine);
 		//System.out.println("Main.docs.line�� ��ġ " + tokSize);
	    	if(inLine == tokSize && !isOpen[styleTagIndex])
	    	{
	    		tokBefore = false;
	    		//System.out.println("�ʱ�ȭ");
				for(int i=0;i<tagIndex;i++) //header �� �� �±� ���Ժκ�
				{ //System.out.println("��");
					msg += tempTag[i];
					 // �ݴ� �ױ� �߰�
				}
				if((lineComp  == (Main.docs[index]).docNodes.size()-1)&&
	        			(inLine == tokSize && !isOpen[styleTagIndex]))
	        	{
					//System.out.println("�����±�");
		    		msg += "\n</body>";
	        		msg +="\n</html>";

	        	}
				inLine=0;
				tagIndex = 0; //�ʱ�ȭ

				return;
	    	}
		//	System.out.println("lineComp " + lineComp);
    	//	System.out.println("Main.docs " + (Main.docs[index].docNodes.size()-1));
    		//System.out.println("inLine " + inLine);


         }

		  catch (IOException e)
         {
             System.err.println(e);
             System.exit(1);
         }
         catch (Exception e){
             System.out.println(e);
         }


		 if(isOpen[styleTagIndex])
			 tokBefore = true;
		 else
			 tokBefore = false;


}
}
