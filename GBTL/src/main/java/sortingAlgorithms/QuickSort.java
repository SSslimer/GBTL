package sortingAlgorithms;

import java.util.Collections;
import java.util.List;
import java.util.Comparator;

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
				if(pivot.compareTo(array[i]) > 0)
				{
					pivotIndex++;
					SortUtils.swap(array, pivotIndex, i);
				}	
			}

			SortUtils.swap(array, left, pivotIndex);
			
			sort(array, left, pivotIndex-1);
			sort(array, pivotIndex+1, right);
		}	
	}
	
	public static<T> void quickSort(T[] array, Comparator<T> comp)
	{
		sort(array, 0, array.length-1, comp);
	}
	
	private static<T> void sort(T[] array, int left, int right, Comparator<T> comp)
	{
		if(left < right)
		{
			T pivot = array[left];
			int pivotIndex = left;
			
			for(int i = left; i <= right; i++)
			{
				if(comp.compare(pivot, array[i]) > 0)
				{
					pivotIndex++;
					SortUtils.swap(array, pivotIndex, i);
				}	
			}

			SortUtils.swap(array, left, pivotIndex);
			
			sort(array, left, pivotIndex-1, comp);
			sort(array, pivotIndex+1, right, comp);
		}	
	}
	
	public static<T extends Comparable<T>> void quickSort(List<T> list)
	{
		sort(list, 0, list.size()-1);
	}
	
	private static<T extends Comparable<T>> void sort(List<T> list, int left, int right)
	{
		if(left < right)
		{
			T pivot = list.get(left);
			int pivotIndex = left;
			
			for(int i = left; i <= right; i++)
			{
				if(pivot.compareTo(list.get(i)) > 0)
				{
					pivotIndex++;
					Collections.swap(list, pivotIndex, i);
				}	
			}

			Collections.swap(list, left, pivotIndex);
			
			sort(list, left, pivotIndex-1);
			sort(list, pivotIndex+1, right);
		}	
	}
	
	public static<T> void quickSort(List<T> list, Comparator<T> comp)
	{
		sort(list, 0, list.size()-1, comp);
	}
	
	private static<T> void sort(List<T> list, int left, int right, Comparator<T> comp)
	{
		if(left < right)
		{
			T pivot = list.get(left);
			int pivotIndex = left;
			
			for(int i = left; i <= right; i++)
			{
				if(comp.compare(pivot, list.get(i)) > 0)
				{
					pivotIndex++;
					Collections.swap(list, pivotIndex, i);
				}	
			}

			Collections.swap(list, left, pivotIndex);
			
			sort(list, left, pivotIndex-1, comp);
			sort(list, pivotIndex+1, right, comp);
		}	
	}
	
	public static void quickSort(double[] array)
	{
		sort(array, 0, array.length-1);
	}
	
	private static void sort(double[] array, int left, int right)
	{
		if(left < right)
		{
			double pivot = array[left];
			int pivotIndex = left;
			
			for(int i = left; i <= right; i++)
			{
				if(pivot > array[i])
				{
					pivotIndex++;
					SortUtils.swap(array, pivotIndex, i);
				}	
			}

			SortUtils.swap(array, left, pivotIndex);
			
			sort(array, left, pivotIndex-1);
			sort(array, pivotIndex+1, right);
		}	
	}
	
	public static void quickSort(float[] array)
	{
		sort(array, 0, array.length-1);
	}
	
	private static void sort(float[] array, int left, int right)
	{
		if(left < right)
		{
			float pivot = array[left];
			int pivotIndex = left;
			
			for(int i = left; i <= right; i++)
			{
				if(pivot > array[i])
				{
					pivotIndex++;
					SortUtils.swap(array, pivotIndex, i);
				}	
			}

			SortUtils.swap(array, left, pivotIndex);
			
			sort(array, left, pivotIndex-1);
			sort(array, pivotIndex+1, right);
		}	
	}
	
	public static void quickSort(long[] array)
	{
		sort(array, 0, array.length-1);
	}
	
	private static void sort(long[] array, int left, int right)
	{
		if(left < right)
		{
			long pivot = array[left];
			int pivotIndex = left;
			
			for(int i = left; i <= right; i++)
			{
				if(pivot > array[i])
				{
					pivotIndex++;
					SortUtils.swap(array, pivotIndex, i);
				}	
			}

			SortUtils.swap(array, left, pivotIndex);
			
			sort(array, left, pivotIndex-1);
			sort(array, pivotIndex+1, right);
		}	
	}
	
	public static void quickSort(int[] array)
	{
		sort(array, 0, array.length-1);
	}
	
	private static void sort(int[] array, int left, int right)
	{
		if(left < right)
		{
			int pivot = array[left];
			int pivotIndex = left;
			
			for(int i = left; i <= right; i++)
			{
				if(pivot > array[i])
				{
					pivotIndex++;
					SortUtils.swap(array, pivotIndex, i);
				}	
			}

			SortUtils.swap(array, left, pivotIndex);
			
			sort(array, left, pivotIndex-1);
			sort(array, pivotIndex+1, right);
		}	
	}
	
	public static void quickSort(short[] array)
	{
		sort(array, 0, array.length-1);
	}
	
	private static void sort(short[] array, int left, int right)
	{
		if(left < right)
		{
			short pivot = array[left];
			int pivotIndex = left;
			
			for(int i = left; i <= right; i++)
			{
				if(pivot > array[i])
				{
					pivotIndex++;
					SortUtils.swap(array, pivotIndex, i);
				}	
			}

			SortUtils.swap(array, left, pivotIndex);
			
			sort(array, left, pivotIndex-1);
			sort(array, pivotIndex+1, right);
		}	
	}
	
	public static void quickSort(char[] array)
	{
		sort(array, 0, array.length-1);
	}
	
	private static void sort(char[] array, int left, int right)
	{
		if(left < right)
		{
			char pivot = array[left];
			int pivotIndex = left;
			
			for(int i = left; i <= right; i++)
			{
				if(pivot > array[i])
				{
					pivotIndex++;
					SortUtils.swap(array, pivotIndex, i);
				}	
			}

			SortUtils.swap(array, left, pivotIndex);
			
			sort(array, left, pivotIndex-1);
			sort(array, pivotIndex+1, right);
		}	
	}
}
