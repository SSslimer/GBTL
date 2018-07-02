package sortingAlgorithms;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Random;
import java.util.Arrays;

public class TestSortingAlgorithms 
{
	private static final int ARRAY_SIZE = 15;
	private static Random random = new Random();
	
	private static int[] unsortedArray = {8, 4, 5, 8, 1, 3, 15, -5, 7, 0, 0, 13, 11, 15, 1};
	private static int[] expectedArray = {-5, 0, 0, 1, 1, 3, 4, 5, 7, 8, 8, 11, 13, 15, 15};
	
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
		BubbleSort.bubbleSort(unsortedArray);
		
		for(int i = 0; i < ARRAY_SIZE; i++)
		{
			assertEquals(unsortedArray[i], expectedArray[i]);
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
		int[] sortedArray = InsertSort.insertionSort(unsortedArray);
		
		for(int i = 0; i < ARRAY_SIZE; i++)
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
		MergeSort.mergeSort(array);
		
		for(int i = 0; i < size; i++)
		{
			assertEquals(array[i], array2[i]);
		}
	}
}
