package sortingAlgorithms;

public class BubbleSort 
{
	public static void Bubblesort(int[] array, int size)
	{
		for(int i = 0; i < size; i++)
		{
			for(int j = i+1; j < size; j++)
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
