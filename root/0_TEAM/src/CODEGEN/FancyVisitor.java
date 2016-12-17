//package team;
import java.util.Random;

public class FancyVisitor implements MDElementVisitor {

	public CodeGenerator codeGen = new CodeGenerator(Main.cli);
	public static int i=0,j=0,k=0,l=0;
	public String color;
	Random random = new Random();

	public void visitDocument(Document e)
	{
		 for(j=0;j<e.docNodes.size();j++)
		 {
    		        for(k=0;k<e.docNodes.get(j).nodes.size();k++)
    			   	{
    		        	if(e.docNodes.get(j).nodes.get(k).getClass().getSimpleName().equals("Node"))
    		        	{
    		        		for(l=0;l<e.docNodes.get(j).nodes.get(k).token.tokens.size();l++)
    		        			e.docNodes.get(j).nodes.get(k).token.tokens.get(l).accept(new FancyVisitor());
    		        	}
    		        	else
    		        		e.docNodes.get(j).nodes.get(k).accept(new FancyVisitor());
    			   	}
    	 }
		 i++;
	}
	public void visitNode(Node e)
	{
		int c = random.nextInt(7);
		switch(c)
		{
					case 0: color = "red";
					break;
					case 1: color = "orange";
					break;
					case 2: color = "yellow";
					break;
					case 3: color = "#00ccff";
					break;
					case 4: color = "#00cc00";
					break;
					case 5: color = "#6600ff";
					break;
					case 6: color = "#996600";
					break;

		}


		codeGen.setNode(e, i, j, k, color);

	}
	public void visitToken(Token e)
	{
		int c = random.nextInt(7);
				switch(c)
				{
							case 0: color = "red";
							break;
							case 1: color = "orange";
							break;
							case 2: color = "yellow";
							break;
							case 3: color = "#00ccff";
							break;
							case 4: color = "#00cc00";
							break;
							case 5: color = "#6600ff";
							break;
							case 6: color = "#996600";
							break;

				}

		codeGen.setToken(e, i, j, k, l, color);
	}
}
