package sortingAlgorithms;

public class BubbleSort 
{
	public static void bubbleSort(int[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			for(int j = i+1; j < array.length; j++)
			{
				if(array[i] > array[j])
				{
					swap(array, i, j);
				}
			}
		}
	}
	
	public static void swap(int[] array, int i, int j)
	{
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
