//package team;

public class PlainVisitor implements MDElementVisitor {
	
	CodeGenerator codeGen = new CodeGenerator(Main.cli);
	private static int i=0,j=0,k=0,l=0; //���� document, j�� �ٹ�ȣ, k�� node Ȥ�� token ��ȣ

	public void visitDocument(Document e)
	{
		//System.out.println(e.docNodes.get(j).nodes.size());
		 for(j=0;j<e.docNodes.size();j++)
		 {
    		        for(k=0;k<e.docNodes.get(j).nodes.size();k++)
    			   	{    	//System.out.println(e.docNodes.get(j).nodes.size());
    		        	if(e.docNodes.get(j).nodes.get(k).getClass().getSimpleName().equals("Node")) //��ū�ΰ��!!!
    		        	{
    		        		for(l=0;l<e.docNodes.get(j).nodes.get(k).token.tokens.size();l++)
    		        			e.docNodes.get(j).nodes.get(k).token.tokens.get(l).accept(new PlainVisitor());
    		        	}
    		        	else
    		        		e.docNodes.get(j).nodes.get(k).accept(new PlainVisitor()); //node visitor ȣ���Ѵ�.
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
