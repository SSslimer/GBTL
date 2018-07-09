package sortingAlgorithms;

public class CountingSort 
{
	public static void countingSort(int[] array)
	{
		int[] minMax = {array[0], array[0]};
	
		findBoundaries(array, minMax);
		
		int min = minMax[0];
		int max = minMax[1];
		
		int[] countingArray = new int[max + 1 - min];
		
		for(int i = 0; i < array.length; i++)
		{
			countingArray[array[i] - min]++;
		}
		
		for(int i = 0, index = 0; i < countingArray.length; i++)
		{
			int counter = countingArray[i];
			
			while(counter > 0)
			{
				array[index] = i + min;
				index++;
				counter--;
			}
		}		
	}
	
	private static void findBoundaries(int[] array, int[] minMax)
	{
		for(int i = 1; i < array.length; i++)
		{
			if(array[i] > minMax[1]) minMax[1] = array[i];
			if(array[i] < minMax[0]) minMax[0] = array[i];
		}
	}
	
	public static void countingSort(short[] array)
	{
		short[] minMax = {array[0], array[0]};
			
		findBoundaries(array, minMax);
		
		short min = minMax[0];
		short max = minMax[1];
		
		short[] countingArray = new short[(max+1) - min];
		
		for(int i = 0; i < array.length; i++)
		{
			countingArray[array[i] - min]++;
		}
		
		for(int i = 0, index = 0; i < countingArray.length; i++)
		{
			int counter = countingArray[i];
			
			while(counter > 0)
			{
				array[index] = (short) (i + min);
				index++;
				counter--;
			}
		}		
	}
	
	private static void findBoundaries(short[] array, short[] minMax)
	{
		for(int i = 1; i < array.length; i++)
		{
			if(array[i] > minMax[1]) minMax[1] = array[i];
			if(array[i] < minMax[0]) minMax[0] = array[i];
		}
	}
	
	public static void countingSort(char[] array)
	{
		char[] minMax = {array[0], array[0]};
			
		findBoundaries(array, minMax);
		
		char min = minMax[0];
		char max = minMax[1];
		
		char[] countingArray = new char[(max+1) - min];
		
		for(int i = 0; i < array.length; i++)
		{
			countingArray[array[i] - min]++;
		}
		
		for(int i = 0, index = 0; i < countingArray.length; i++)
		{
			int counter = countingArray[i];
			
			while(counter > 0)
			{
				array[index] = (char) (i + min);
				index++;
				counter--;
			}
		}		
	}
	
	private static void findBoundaries(char[] array, char[] minMax)
	{
		for(int i = 1; i < array.length; i++)
		{
			if(array[i] > minMax[1]) minMax[1] = array[i];
			if(array[i] < minMax[0]) minMax[0] = array[i];
		}
	}
}
