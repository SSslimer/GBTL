package sortingAlgorithms;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class TestCountingSort
{
	@Test
	public void testPrimitiveType()
	{
		int[] array = TestUtils.createRandomArray_int(1000, -100, 100);
		int[] array2 = array.clone();
		
		Arrays.sort(array2);
		CountingSort.countingSort(array);
		
		for(int i = 0; i < array.length; i++)
		{
			assertEquals(array[i], array2[i]);
		}
		
		//////////////////////////////////////////////////
		
		char[] array_char = TestUtils.createRandomArray_char(1000, (char)0, (char)100);
		char[] array2_char = array_char.clone();
		
		Arrays.sort(array2_char);
		BubbleSort.bubbleSort(array_char);
		
		for(int i = 0; i < array_char.length; i++)
		{
			assertEquals(array_char[i], array2_char[i]);
		}
		
		//////////////////////////////////////////////////
		
		short[] array_short = TestUtils.createRandomArray_short(1000, (short)0, (short)100);
		short[] array2_short = array_short.clone();
		
		Arrays.sort(array2_short);
		BubbleSort.bubbleSort(array_short);
		
		for(int i = 0; i < array_short.length; i++)
		{
			assertEquals(array_short[i], array2_short[i]);
		}
	}	
}
