package sortingAlgorithms;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestQuickSort
{

	@Test
	public void testPrimitiveType()
	{
		int[] array = TestUtils.createRandomArray_int(1000);
		int[] array2 = array.clone();
		
		Arrays.sort(array2);
		QuickSort.quickSort(array);
		
		for(int i = 0; i < array.length; i++)
		{
			assertEquals(array[i], array2[i]);
		}
	}

}
