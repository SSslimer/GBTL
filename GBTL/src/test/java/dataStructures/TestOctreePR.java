package dataStructures;

import static org.junit.Assert.assertFalse;

import java.util.Random;

import org.junit.Test;

public class TestOctreePR
{
	@Test
	public void testRemove()
	{
		final int ELEMENTS = 1_000_000;
		Random random = new Random();
		OctreePR<Integer> tree = new OctreePR<>(2, 16, 100, 100, 100);
		
		Integer[] values = new Integer[ELEMENTS];
		int[] x = new int[ELEMENTS];
		int[] y = new int[ELEMENTS];
		int[] z = new int[ELEMENTS];
		
		for(int i = 0; i < 1000; i++)
		{
			values[i] = random.nextInt();
			x[i] = random.nextInt(200)-100;
			y[i] = random.nextInt(200)-100;
			z[i] = random.nextInt(200)-100;
			
			tree.add(values[i], x[i], y[i], z[i]);
		}
		
		for(int i = 0; i < 100; i++)
		{
			int j = random.nextInt(ELEMENTS);
			
			if(values[j] != null)
			{
				tree.remove(values[j], x[j], y[j], z[j]);
				assertFalse(tree.contains(values[j], x[j], y[j], z[j]));
			}		
		}		
	}

}
