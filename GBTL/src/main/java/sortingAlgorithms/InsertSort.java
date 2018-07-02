package sortingAlgorithms;

public class InsertSort 
{
	public static int[] insertionSort(int[] array)
	{
		int[] newArray = new int[array.length];
		newArray[0] = array[0];
		
		int newArraySize = 1;
		
		for(int i = 1; i < array.length; i++)
		{
			newArray[newArraySize] = array[i];
			
			for(int j = newArraySize - 1; j >= 0; j--)
			{			
				int k = j+1;
				if(newArray[k] < newArray[j])
				{
					swap(newArray, j, k);
				}
				else
				{
					break;
				}
				
			}
			
			newArraySize++;
		}
		
		return newArray;
	}
	
	public static void swap(int[] array, int i, int j)
	{
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
		
}
