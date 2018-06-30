package sortingAlgorithms;

public class QuickSort 
{
	public static void Quicksort(int[] array, int left, int right)
	{
		if(left < right)
		{
			int pivot = array[left];
			int pivotIndex = left;
			
			for(int i = left; i <= right; i++)
			{
				if(array[i] < pivot)
				{
					pivotIndex++;
					swap(array, pivotIndex, i);
				}	
			}
			
			//we move pivot as many places as there were smaller values from it
			swap(array, left, pivotIndex);
			
			Quicksort(array, left, pivotIndex-1);
			Quicksort(array, pivotIndex+1, right);
		}	
	}
	
	public static void swap(int[] array, int i, int j)
	{
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
