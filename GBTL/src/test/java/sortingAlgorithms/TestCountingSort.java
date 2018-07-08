package sortingAlgorithms;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestCountingSort
{
	@Test
	public void testPrimitiveType()
	{
		int[] array = TestUtils.createRandomArray_int(100000, -100, 100);
		int[] array2 = array.clone();
		
		Arrays.sort(array2);
		CountingSort.countingSort(array);
		
		for(int i = 0; i < array.length; i++)
		{
			assertEquals(array[i], array2[i]);
		}
	}
}
