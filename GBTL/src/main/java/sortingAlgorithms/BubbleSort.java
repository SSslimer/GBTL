package sortingAlgorithms;

import static sortingAlgorithms.SortUtils.swap;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BubbleSort
{
	public static <T extends Comparable<T>> void bubbleSort(T[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			for(int j = i+1; j < array.length; j++)
			{
				if(array[i].compareTo(array[j]) > 0)
				{
					swap(array, i, j);
				}
			}
		}
	}
	
	public static <T> void bubbleSort(T[] array, Comparator<T> comp)
	{
		for(int i = 0; i < array.length; i++)
		{
			for(int j = i+1; j < array.length; j++)
			{
				if(comp.compare(array[i], array[j]) > 0)
				{
					swap(array, i, j);
				}
			}
		}
	}
	
	public static <T extends Comparable<T>> void bubbleSort(List<T> list)
	{
		for(int i = 0; i < list.size(); i++)
		{
			for(int j = i+1; j < list.size(); j++)
			{
				if(list.get(i).compareTo(list.get(j)) > 0)
				{
					Collections.swap(list, i, j);
				}
			}
		}
	}
	
	public static <T> void bubbleSort(List<T> list, Comparator<T> comp)
	{
		for(int i = 0; i < list.size(); i++)
		{
			for(int j = i+1; j < list.size(); j++)
			{
				if(comp.compare(list.get(i), list.get(j)) > 0)
				{
					Collections.swap(list, i, j);
				}
			}
		}
	}
	
	public static void bubbleSort(double[] array)
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
	
	public static void bubbleSort(float[] array)
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
	
	public static void bubbleSort(long[] array)
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
	
	public static void bubbleSort(short[] array)
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
	
	public static void bubbleSort(char[] array)
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
}
