package sortingAlgorithms;

import static sortingAlgorithms.SortUtils.*;

public class QuickSort 
{
	public static<T extends Comparable<T>> void quickSort(T[] array)
	{
		sort(array, 0, array.length-1);
	}
	
	private static<T extends Comparable<T>> void sort(T[] array, int left, int right)
	{
		if(left < right)
		{
			T pivot = array[left];
			int pivotIndex = left;
			
			for(int i = left; i <= right; i++)
			{
				//if(array[i] < pivot)
				if(pivot.compareTo(array[i]) > 0)
				{
					pivotIndex++;
					swap(array, pivotIndex, i);
				}	
			}
			
			//we move pivot as many places as there were smaller values from it
			swap(array, left, pivotIndex);
			
			sort(array, left, pivotIndex-1);
			sort(array, pivotIndex+1, right);
		}	
	}
}
