package sortingAlgorithms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class TestSortingAlgorithms 
{
	int arraySize = 15;
	
	int[] unsortedArray = {8, 4, 5, 8, 1, 3, 15, -5, 7, 0, 0, 13, 11, 15, 1};
	int[] expectedArray = {-5, 0, 0, 1, 1, 3, 4, 5, 7, 8, 8, 11, 13, 15, 15};
	
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
}
