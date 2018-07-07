package sortingAlgorithms;

import java.lang.reflect.Array;
import static sortingAlgorithms.SortUtils.*;

public class InsertSort 
{
	public static<T extends Comparable<T>> void insertionSort(T[] array)
	{	
		@SuppressWarnings("unchecked")
		T[] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);
		newArray[0] = array[0];
		
		int newArraySize = 1;
		
		for(int i = 1; i < array.length; i++)
		{
			newArray[newArraySize] = array[i];
			
			for(int j = newArraySize - 1; j >= 0; j--)
			{			
				int k = j+1;
				T x = newArray[j];
				T y = newArray[k];
				//if(newArray[j].compareTo(newArray[k]) > 0)
				if(x.compareTo(y) > 0)
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
		
		for(int i = 0; i < array.length; i++)
		{
			array[i] = newArray[i];
		}		
	}	
}

/*
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
} */
