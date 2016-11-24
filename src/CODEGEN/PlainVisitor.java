//package team;

public class PlainVisitor implements MDElementVisitor {
	
	CodeGenerator codeGen = new CodeGenerator(Main.cli);
	private static int i=0,j=0,k=0,l=0; //각각 document, j는 줄번호, k는 node 혹은 token 번호

	public void visitDocument(Document e)
	{
		//System.out.println(e.docNodes.get(j).nodes.size());
		 for(j=0;j<e.docNodes.size();j++)
		 {
    		        for(k=0;k<e.docNodes.get(j).nodes.size();k++)
    			   	{    	//System.out.println(e.docNodes.get(j).nodes.size());
    		        	if(e.docNodes.get(j).nodes.get(k).getClass().getSimpleName().equals("Node")) //토큰인경우!!!
    		        	{
    		        		for(l=0;l<e.docNodes.get(j).nodes.get(k).token.tokens.size();l++)
    		        			e.docNodes.get(j).nodes.get(k).token.tokens.get(l).accept(new PlainVisitor());
    		        	}
    		        	else
    		        		e.docNodes.get(j).nodes.get(k).accept(new PlainVisitor()); //node visitor 호출한다.
    			   	}
    	 }
		 i++;
	}
	public void visitNode(Node e)
	{
		codeGen.setNode(e, i, j);
		
	}
	public void visitToken(Token e)
	{
		
		codeGen.setToken(e, i, j, k, l);
	}
}
