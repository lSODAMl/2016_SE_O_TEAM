//package team;

public class FancyVisitor implements MDElementVisitor {
	
	CodeGenerator codeGen = new CodeGenerator(Main.cli);
	static int i=0,j=0,k=0,l=0; //���� document, j�� �ٹ�ȣ, k�� node Ȥ�� token ��ȣ
	private String color;

	public void visitDocument(Document e)
	{
		 for(j=0;j<e.docNodes.size();j++)
		 {
    		        for(k=0;k<e.docNodes.get(j).nodes.size();k++)
    			   	{    	
    		        	if(e.docNodes.get(j).nodes.get(k).getClass().getSimpleName().equals("Node")) //��ū�ΰ��!!!
    		        	{
    		        		for(l=0;l<e.docNodes.get(j).nodes.get(k).token.tokens.size();l++)
    		        			e.docNodes.get(j).nodes.get(k).token.tokens.get(l).accept(new FancyVisitor());
    		        	}
    		        	else
    		        		e.docNodes.get(j).nodes.get(k).accept(new FancyVisitor()); //node visitor ȣ���Ѵ�.
    			   	}
    	 }
		 i++;
	}
	public void visitNode(Node e)
	{
		color = "blue";
		codeGen.setNode(e, i, j, color);
		
	}
	public void visitToken(Token e)
	{
		color = "blue";
		codeGen.setToken(e, i, j, k, l, color);
	}
}
