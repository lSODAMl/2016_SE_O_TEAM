package test;

import static org.junit.Assert.*;

import org.junit.Test;

import IR.CodeBlock;


public class CodeBlockTest {

	@Test
	public void IsCodeBlockTest() {
		//Expected True
		assertTrue("CodeBlockfailed",  CodeBlock.IsCodeBlock("```"));
		//Expected false
		assertFalse("CodeBlockfailed",  CodeBlock.IsCodeBlock("this one ```should fai``l`"));
		assertFalse("CodeBlockfailed",  CodeBlock.IsCodeBlock("`this one too``"));

	}

	
}
