package sortingAlgorithms;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SelectionSort 
{
	public static<T extends Comparable<T>> void selectionSort(T[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			for(int j = i+1; j < array.length; j++)
			{
				if(array[j].compareTo(array[i]) < 0)
				{
					SortUtils.swap(array, i, j);
				}
			}	
		}
	}

	public static<T> void selectionSort(T[] array, Comparator<T> comp)
	{
		for(int i = 0; i < array.length; i++)
		{
			for(int j = i+1; j < array.length; j++)
			{
				if(comp.compare(array[j], array[i]) < 0)	
				{
					SortUtils.swap(array, i, j);
				}
			}
		}
	}

	public static<T extends Comparable<T>> void selectionSort(List<T> list)
	{
		for(int i = 0; i < list.size(); i++)
		{
			for(int j = i+1; j < list.size(); j++)
			{
				if(list.get(j).compareTo(list.get(i)) < 0)
				{
					Collections.swap(list, i, j);
				}
			}
		}
	}

	public static<T> void selectionSort(List<T> list, Comparator<T> comp)
	{
		for(int i = 0; i < list.size(); i++)
		{
			for(int j = i+1; j < list.size(); j++)
			{
				if(comp.compare(list.get(j), list.get(i)) < 0)
				{
					Collections.swap(list, i, j);
				}
			}
		}
	}

	public static void selectionSort(double[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			for(int j = i+1; j < array.length; j++)
			{
				if(array[j] < array[i])
				{
					SortUtils.swap(array, i, j);
				}
			}
		}
	}

	public static void selectionSort(float[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			for(int j = i+1; j < array.length; j++)
			{
				if(array[j] < array[i])
				{
					SortUtils.swap(array, i, j);
				}
			}
		}
	}

	public static void selectionSort(long[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			for(int j = i+1; j < array.length; j++)
			{
				if(array[j] < array[i])
				{
					SortUtils.swap(array, i, j);
				}
			}
		}
	}
	public static void selectionSort(int[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			for(int j = i+1; j < array.length; j++)
			{
				if(array[j] < array[i])
				{
					SortUtils.swap(array, i, j);
				}
			}
		}
	}

	public static void selectionSort(short[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			for(int j = i+1; j < array.length; j++)
			{
				if(array[j] < array[i])
				{
					SortUtils.swap(array, i, j);
				}
			}
		}
	}

	public static void selectionSort(char[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			for(int j = i+1; j < array.length; j++)
			{
				if(array[j] < array[i])
				{
					SortUtils.swap(array, i, j);
				}
			}
		}
	}

}
