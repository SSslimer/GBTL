package sortingAlgorithms;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Random;
import java.util.Arrays;

public class TestSortingAlgorithms 
{
	int arraySize = 15;
	Random random = new Random();
	
	int[] unsortedArray = {8, 4, 5, 8, 1, 3, 15, -5, 7, 0, 0, 13, 11, 15, 1};
	int[] expectedArray = {-5, 0, 0, 1, 1, 3, 4, 5, 7, 8, 8, 11, 13, 15, 15};
	
	public int[] createRandomArray(int arraySize)
	{
		
		int[] array = new int[arraySize];
		
		for(int i = 0; i < arraySize; i++)
		{
			array[i] = random.nextInt(40) - 20;
		}
		
		return array;
	}
	
	@Test
	public void testBubbleSort()
	{
		BubbleSort.Bubblesort(unsortedArray, arraySize);
		
		for(int i = 0; i < arraySize; i++)
		{
			assertEquals(unsortedArray[i], expectedArray[i]);
		}
	}
	
	@Test
	public void testQuickSort()
	{
		QuickSort.Quicksort(unsortedArray, 0, arraySize-1);
		
		for(int i = 0; i < arraySize; i++)
		{
			assertEquals(unsortedArray[i], expectedArray[i]);
		}
	}
	
	@Test
	public void testInsertSort()
	{
		int[] sortedArray = InsertSort.Insertsort(unsortedArray, arraySize);
		
		for(int i = 0; i < arraySize; i++)
		{
			assertEquals(sortedArray[i], expectedArray[i]);
		}
	}
	
	@Test
	public void testMergeSort()
	{
		int size = random.nextInt(15) + 5;//size from 5 to 20
		
		int[] array = createRandomArray(size); 
		int[] array2 = new int[size];
		
		for(int i = 0; i < size; i++)
		{
			array2[i] = array[i];
		}
		
		Arrays.sort(array2);
		MergeSort.Mergesort(array, 0, size-1, size);
		
		for(int i = 0; i < size; i++)
		{
			assertEquals(array[i], array2[i]);
		}
	}
}
