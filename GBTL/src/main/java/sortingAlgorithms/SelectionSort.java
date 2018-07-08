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
			selectMinimum(array, i);
		}
	}
	
	private static<T extends Comparable<T>> void selectMinimum(T[] array, int beginningIndex)
	{	
		for(int i = beginningIndex+1; i < array.length; i++)
		{
			if(array[i].compareTo(array[beginningIndex]) < 0)
			{
				SortUtils.swap(array, beginningIndex, i);
			}
		}
	}
	
	public static<T> void selectionSort(T[] array, Comparator<T> comp)
	{
		for(int i = 0; i < array.length; i++)
		{
			selectMinimum(array, i, comp);
		}
	}
	
	private static<T> void selectMinimum(T[] array, int beginningIndex, Comparator<T> comp)
	{	
		for(int i = beginningIndex+1; i < array.length; i++)
		{
			if(comp.compare(array[i], array[beginningIndex]) < 0)	
			{
				SortUtils.swap(array, beginningIndex, i);
			}
		}
	}
	
	public static<T extends Comparable<T>> void selectionSort(List<T> list)
	{
		for(int i = 0; i < list.size(); i++)
		{
			selectMinimum(list, i);
		}
	}
	
	private static<T extends Comparable<T>> void selectMinimum(List<T> list, int beginningIndex)
	{	
		for(int i = beginningIndex+1; i < list.size(); i++)
		{
			if(list.get(i).compareTo(list.get(beginningIndex)) < 0)
			{
				Collections.swap(list, beginningIndex, i);
			}
		}
	}
	
	public static<T> void selectionSort(List<T> list, Comparator<T> comp)
	{
		for(int i = 0; i < list.size(); i++)
		{
			selectMinimum(list, i, comp);
		}
	}
	
	private static<T> void selectMinimum(List<T> list, int beginningIndex, Comparator<T> comp)
	{	
		for(int i = beginningIndex+1; i < list.size(); i++)
		{
			if(comp.compare(list.get(i), list.get(beginningIndex)) < 0)
			{
				Collections.swap(list, beginningIndex, i);
			}
		}
	}
	
	public static void selectionSort(double[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			selectMinimum(array, i);
		}
	}
	
	private static void selectMinimum(double[] array, int beginningIndex)
	{	
		for(int i = beginningIndex+1; i < array.length; i++)
		{
			if(array[i] < array[beginningIndex])
			{
				SortUtils.swap(array, beginningIndex, i);
			}
		}
	}
	
	public static void selectionSort(float[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			selectMinimum(array, i);
		}
	}
	
	private static void selectMinimum(float[] array, int beginningIndex)
	{	
		for(int i = beginningIndex+1; i < array.length; i++)
		{
			if(array[i] < array[beginningIndex])
			{
				SortUtils.swap(array, beginningIndex, i);
			}
		}
	}
	
	public static void selectionSort(long[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			selectMinimum(array, i);
		}
	}
	
	private static void selectMinimum(long[] array, int beginningIndex)
	{	
		for(int i = beginningIndex+1; i < array.length; i++)
		{
			if(array[i] < array[beginningIndex])
			{
				SortUtils.swap(array, beginningIndex, i);
			}
		}
	}
	
	public static void selectionSort(int[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			selectMinimum(array, i);
		}
	}
	
	private static void selectMinimum(int[] array, int beginningIndex)
	{	
		for(int i = beginningIndex+1; i < array.length; i++)
		{
			if(array[i] < array[beginningIndex])
			{
				SortUtils.swap(array, beginningIndex, i);
			}
		}
	}
	
	public static void selectionSort(short[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			selectMinimum(array, i);
		}
	}
	
	private static void selectMinimum(short[] array, int beginningIndex)
	{	
		for(int i = beginningIndex+1; i < array.length; i++)
		{
			if(array[i] < array[beginningIndex])
			{
				SortUtils.swap(array, beginningIndex, i);
			}
		}
	}
	
	public static void selectionSort(char[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			selectMinimum(array, i);
		}
	}
	
	private static void selectMinimum(char[] array, int beginningIndex)
	{	
		for(int i = beginningIndex+1; i < array.length; i++)
		{
			if(array[i] < array[beginningIndex])
			{
				SortUtils.swap(array, beginningIndex, i);
			}
		}
	}
}
