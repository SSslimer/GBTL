package sortingAlgorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Random;
import java.util.Arrays;

public class TestSortingAlgorithms 
{
	private static final int ARRAY_SIZE = 15;
	private static Random random = new Random();
	
	private static Integer[] unsortedArray = {8, 4, 5, 8, 1, 3, 15, -5, 7, 0, 0, 13, 11, 15, 1};
	private static Integer[] expectedArray = {-5, 0, 0, 1, 1, 3, 4, 5, 7, 8, 8, 11, 13, 15, 15};
	
	public Integer[] createRandomArray(int arraySize)
	{	
		Integer[] array = new Integer[arraySize];
		
		for(int i = 0; i < arraySize; i++)
		{
			array[i] = random.nextInt(40) - 20;
		}
		
		return array;
	}
	
	@Test
	public void testBubbleSort()
	{
		BubbleSort.bubbleSort(unsortedArray);
		
		for(int i = 0; i < ARRAY_SIZE; i++)
		{
			assertEquals(unsortedArray[i], expectedArray[i]);
		}
		
		//////////////////////////////////////////////////
		
		double[] array = new double[500];		
		for(int i = array.length-1; i >= 0; i--)
		{
			array[i] = random.nextDouble();
		}
		double[] array2 = array.clone();
		
		BubbleSort.bubbleSort(array);
		Arrays.sort(array2);
		
		for(int i = array.length-1; i >= 0; i--)
		{
			assertTrue(array[i] == array2[i]);
		}
		
	}

	@Test
	public void testQuickSort()
	{
		QuickSort.quickSort(unsortedArray);
		
		for(int i = 0; i < ARRAY_SIZE; i++)
		{
			assertEquals(unsortedArray[i], expectedArray[i]);
		} 
	}
	
	@Test
	public void testInsertSort()
	{
		InsertSort.insertionSort(unsortedArray);
		
		for(int i = 0; i < ARRAY_SIZE; i++)
		{
			assertEquals(unsortedArray[i], expectedArray[i]);
		}
	}
	
	@Test
	public void testMergeSort()
	{
		int size = random.nextInt(15) + 5;//size from 5 to 20
		
		Integer[] array = createRandomArray(size); 
		Integer[] array2 = new Integer[size];
		
		for(int i = 0; i < size; i++)
		{
			array2[i] = array[i];
		}
		
		Arrays.sort(array2);
		MergeSort.mergeSort(array);
		
		for(int i = 0; i < size; i++)
		{
			assertEquals(array[i], array2[i]);
		}
	}
}
