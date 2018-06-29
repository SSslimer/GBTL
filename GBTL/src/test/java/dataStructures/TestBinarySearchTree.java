package dataStructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

public class TestBinarySearchTree
{
	@Test
	public void testAdd()
	{
		BinarySearchTree tree = new BinarySearchTree();
		
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
		BinarySearchTree tree = new BinarySearchTree();
		
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
	
	@Test
	public void testRemove()
	{
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.add(3);
		tree.add(2);
		
		assertTrue(tree.contains(3));
		assertTrue(tree.contains(2));		
		assertEquals(2, tree.getSize());
		
		tree.remove(2);		
		assertFalse(tree.contains(2));
		assertEquals(1, tree.getSize());
		
		tree.remove(3);		
		assertFalse(tree.contains(3));
		assertEquals(0, tree.getSize());
				
		tree.add(3);
		tree.add(8);
		tree.add(20);
		tree.add(15);
		tree.add(9);
		tree.add(12);
		tree.remove(8);	
		assertTrue(tree.contains(3));
		assertTrue(tree.contains(20));
		assertTrue(tree.contains(15));
		assertTrue(tree.contains(9));
		assertTrue(tree.contains(12));
		assertFalse(tree.contains(8));
		
		assertEquals(5, tree.getSize());
	}
	
	@Test
	public void testSize()
	{
		Random random = new Random();
		
		for(int test = 0; test < 1; test++)
		{
			BinarySearchTree tree = new BinarySearchTree();
			
			int expectedSize = 100000; random.nextInt(10000);
			
			for(int size = 0; size < expectedSize;)
			{
				int value = random.nextInt(1000000);
				if(!tree.contains(value))
				{
					tree.add(value);
					size++;
				}
			}
			
			assertEquals(expectedSize, tree.getSize());
		}	
	}
	
	@Test
	public void testToSortedArray()
	{
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.add(3);
		tree.add(2);
		tree.add(8);
		tree.add(5);
		tree.add(12);
		tree.add(58);
		tree.add(42);
		
		int[] sorted = tree.toSortedArray();
		
		for(int i = 0; i < sorted.length-1; i++)
		{
			assertTrue(sorted[i] <= sorted[i+1]);
		};
		
	}
	
}
