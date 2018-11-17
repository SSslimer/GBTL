package dataStructures;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import dataStructures.trees.quadtrees.QuadTreePR;

public class TestQuadTreePR
{	
	@Test
	public void testAddAndContains()
	{
		QuadTreePR<String> tree = new QuadTreePR<>(2, 5, 100, 100);
		tree.add("ence", 1, 1);
		tree.add("pence", -1, 1);
		tree.add("w", 1, -1);
		tree.add("której", -1, -1);
		tree.add("ręce", 1, 60);

		assertTrue(tree.contains("ence"));
		assertTrue(tree.contains("pence"));
		assertTrue(tree.contains("w"));
		assertTrue(tree.contains("której"));
		assertTrue(tree.contains("ręce"));
		assertFalse(tree.contains("NON_EXISTING_ELEMENT"));
		
		assertTrue(tree.contains("ence", 1, 1));
		assertTrue(tree.contains("pence", -1, 1));
		assertTrue(tree.contains("w", 1, -1));
		assertTrue(tree.contains("której", -1, -1));
		assertTrue(tree.contains("ręce", 1, 60));
		assertFalse(tree.contains("NON_EXISTING_ELEMENT", 15, -70));
		
		final int entries = 10000;
		QuadTreePR<Integer> tree2 = new QuadTreePR<>(10, 5, 100, 100);

		List<Integer> values = new ArrayList<>(entries);
		Random random = new Random();
		for(int i = 0; i < entries; i++)
		{
			int x = random.nextInt(200)-100;
			int y = random.nextInt(200)-100;
			Integer value = random.nextInt();
			tree2.add(value, x, y);
			values.add(value);
		}
		
		for(int i = 0; i < entries; i++)
		{
			Integer value = values.get(i);
			assertTrue(tree2.contains(value));
		}		
	}
	
	@Test
	public void testRemove()
	{
		final int ELEMENTS = 1_000_000;
		Random random = new Random();
		QuadTreePR<Integer> tree = new QuadTreePR<>(2, 16, 100, 100);
		
		Integer[] values = new Integer[ELEMENTS];
		int[] x = new int[ELEMENTS];
		int[] y = new int[ELEMENTS];
		
		for(int i = 0; i < 1000; i++)
		{
			values[i] = random.nextInt();
			x[i] = random.nextInt(200)-100;
			y[i] = random.nextInt(200)-100;
			
			tree.add(values[i], x[i], y[i]);
		}
		
		for(int i = 0; i < 100; i++)
		{
			int j = random.nextInt(ELEMENTS);
			
			if(values[j] != null)
			{
				tree.remove(values[j], x[j], y[j]);
				assertFalse(tree.contains(values[j], x[j], y[j]));
			}		
		}		
	}
}
