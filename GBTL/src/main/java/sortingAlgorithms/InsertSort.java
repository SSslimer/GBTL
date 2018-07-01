package sortingAlgorithms;

public class InsertSort 
{
	public static int[] Insertsort(int[] array, int size)
	{
		int[] newArray = new int[size];
		newArray[0] = array[0];
		
		int newArraySize = 1;
		
		for(int i = 1; i < size; i++)
		{
			newArray[newArraySize] = array[i];
			
			for(int j = newArraySize - 1; j >= 0; j--)
			{
				
				if(newArray[j+1] < newArray[j])
				{
					swap(newArray, j, j+1);
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
