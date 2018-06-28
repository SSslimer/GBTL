package dataStructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestBinaryTree
{

	@Test
	public void testAdd()
	{
		BinaryTree tree = new BinaryTree();
		
		tree.add(3);
		tree.add(2);
		tree.add(2);
		tree.add(2);
		tree.add(2);
		tree.add(8);
		tree.add(5);
		tree.add(12);
		tree.add(58);
		tree.add(42);
		
		assertTrue(tree.contains(3));
		assertTrue(tree.contains(2));
		assertTrue(tree.contains(8));
		assertTrue(tree.contains(5));
		assertTrue(tree.contains(12));
		assertTrue(tree.contains(58));
		assertTrue(tree.contains(42));
	}

	@Test
	public void testMinAndMax()
	{
		BinaryTree tree = new BinaryTree();
		
		tree.add(3);
		tree.add(2);
		tree.add(8);
		tree.add(5);
		tree.add(12);
		tree.add(58);
		tree.add(42);
		
		try
		{
			assertEquals(58, tree.getMax());
			assertEquals(2, tree.getMin());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
