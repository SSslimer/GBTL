package sortingAlgorithms;

import java.lang.reflect.Array;

public class HeapSort 
{
	public static <T extends Comparable<T>> void heapSort(T[] array)
	{
		@SuppressWarnings("unchecked")
		T[] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);
		
		int size = array.length;
		
		for(int i = 0; i < array.length; i++, size--)
		{
			createHeap(array, size);
			newArray[size-1] = array[0];
			
			SortUtils.swap(array, 0, size-1);	
		}
		
		for(int i = 0; i < array.length; i++)
		{
			array[i] = newArray[i];
		}
	}
	
	private static <T extends Comparable<T>> void createHeap(T[] array, int size)
	{
		@SuppressWarnings("unchecked")
		T[] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), size);
		
		for(int i = 0; i < size; i++)
		{
			newArray[i] = array[i];
			int j = i;
			
			while(j > 0)
			{
				int parentIndex;
				
				if(j%2 == 0)
				{
					parentIndex = (j - 2) / 2;
				}
				else
				{
					parentIndex = (j - 1) / 2;
				}
				
				if(newArray[j].compareTo(newArray[parentIndex]) > 0)
				{
					SortUtils.swap(newArray, parentIndex, j);
					j = parentIndex;
					continue;
				}
				else
				{
					break;
				}
			}
			
		}
		
		for(int i = 0; i < size; i++)
		{
			array[i] = newArray[i];
		}
	}
}
