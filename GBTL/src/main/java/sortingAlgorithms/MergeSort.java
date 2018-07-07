package sortingAlgorithms;

import java.lang.reflect.Array;

public class MergeSort 
{
	public static<T extends Comparable<T>> void mergeSort(T[] array)
	{
		sort(array, 0, array.length-1);
	}
	
	private static<T extends Comparable<T>> void sort(T[] array, int left, int right)
	{
		if(left < right)
		{
			int middle = (left + right) / 2;
			
			sort(array, left, middle);
			sort(array, middle+1, right);
			
			merge(array, left, middle, right);
		}		
	}
	
	private static<T extends Comparable<T>> void merge(T[] array, int left, int middle, int right)
	{		
		@SuppressWarnings("unchecked")
		T[] mergedArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);
		
		int left1 = left;
		int right1 = middle;
		int left2 = middle + 1;
		int right2 = right;
		
		int mergedArrayIndex = left;
		
		while(mergedArrayIndex <= right)
		{
			if(left1 > right1 && left2 <= right2)
			{
				mergedArray[mergedArrayIndex] = array[left2];
				left2++;
				mergedArrayIndex++;
				continue;
			}
			else if(left2 > right2 && left1 <= right1)
			{
				mergedArray[mergedArrayIndex] = array[left1];
				left1++;
				mergedArrayIndex++;
				continue;
			}

			if(array[left2].compareTo(array[left1]) > 0)
			{
				mergedArray[mergedArrayIndex] = array[left1];
				left1++;
				mergedArrayIndex++;
			}
			else
			{
				mergedArray[mergedArrayIndex] = array[left2];
				left2++;
				mergedArrayIndex++;
			}
		}
		
		for(int i = left; i <= right; i++)
		{
			array[i] = mergedArray[i];
		}
	}
}
