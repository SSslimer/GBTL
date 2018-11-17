package sortingAlgorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
			
		for(int mergedArrayIndex = left; mergedArrayIndex <= right; mergedArrayIndex++)
		{
			if(left1 > right1 && left2 <= right2)
			{
				mergedArray[mergedArrayIndex] = array[left2];
				left2++;
			}
			else if(left2 > right2 && left1 <= right1)
			{
				mergedArray[mergedArrayIndex] = array[left1];
				left1++;
			}
			else if(array[left2].compareTo(array[left1]) > 0)
			{
				mergedArray[mergedArrayIndex] = array[left1];
				left1++;
			}
			else
			{
				mergedArray[mergedArrayIndex] = array[left2];
				left2++;
			}
		}
		
		System.arraycopy(mergedArray, left, array, left, right-left+1);
	}
	
	public static<T> void mergeSort(T[] array, Comparator<T> comp)
	{
		sort(array, 0, array.length-1, comp);
	}
	
	private static<T> void sort(T[] array, int left, int right, Comparator<T> comp)
	{
		if(left < right)
		{
			int middle = (left + right) / 2;
			
			sort(array, left, middle, comp);
			sort(array, middle+1, right, comp);
			
			merge(array, left, middle, right, comp);
		}		
	}
	
	private static<T> void merge(T[] array, int left, int middle, int right, Comparator<T> comp)
	{
		@SuppressWarnings("unchecked")
		T[] mergedArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);
		
		int left1 = left;
		int right1 = middle;
		int left2 = middle + 1;
		int right2 = right;
		

		for(int mergedArrayIndex = left; mergedArrayIndex <= right; mergedArrayIndex++)
		{
			if(left1 > right1 && left2 <= right2)
			{
				mergedArray[mergedArrayIndex] = array[left2];
				left2++;
			}
			else if(left2 > right2 && left1 <= right1)
			{
				mergedArray[mergedArrayIndex] = array[left1];
				left1++;
			}
			else if(comp.compare(array[left2], array[left1]) > 0)
			{
				mergedArray[mergedArrayIndex] = array[left1];
				left1++;
			}
			else
			{
				mergedArray[mergedArrayIndex] = array[left2];
				left2++;
			}
		}
		
		System.arraycopy(mergedArray, left, array, left, right-left+1);
	}
	
	public static<T extends Comparable<T>> void mergeSort(List<T> list)
	{
		sort(list, 0, list.size()-1);
	}
	
	private static<T extends Comparable<T>> void sort(List<T> list, int left, int right)
	{
		if(left < right)
		{
			int middle = (left + right) / 2;
			
			sort(list, left, middle);
			sort(list, middle+1, right);
			
			merge(list, left, middle, right);
		}		
	}
	
	private static<T extends Comparable<T>> void merge(List<T> list, int left, int middle, int right)
	{		
		List<T> mergedList = new ArrayList<>(list);
		
		int left1 = left;
		int right1 = middle;
		int left2 = middle + 1;
		int right2 = right;
		
		for(int mergedArrayIndex = left; mergedArrayIndex <= right; mergedArrayIndex++)
		{
			if(left1 > right1 && left2 <= right2)
			{
				mergedList.set(mergedArrayIndex, list.get(left2));
				left2++;
			}
			else if(left2 > right2 && left1 <= right1)
			{
				mergedList.set(mergedArrayIndex, list.get(left1));
				left1++;
			}
			else if(list.get(left2).compareTo(list.get(left1)) > 0)
			{
				mergedList.set(mergedArrayIndex, list.get(left1));
				left1++;
			}
			else
			{
				mergedList.set(mergedArrayIndex, list.get(left2));
				left2++;
			}
		}
		
		for(int i = left; i <= right; i++)
		{
			list.set(i, mergedList.get(i));
		}
	}
	
	public static<T> void mergeSort(List<T> list, Comparator<T> comp)
	{
		sort(list, 0, list.size()-1, comp);
	}
	
	private static<T> void sort(List<T> list, int left, int right, Comparator<T> comp)
	{
		if(left < right)
		{
			int middle = (left + right) / 2;
			
			sort(list, left, middle, comp);
			sort(list, middle+1, right, comp);
			
			merge(list, left, middle, right, comp);
		}		
	}
	
	private static<T> void merge(List<T> list, int left, int middle, int right, Comparator<T> comp)
	{		
		List<T> mergedList = new ArrayList<>(list);
		
		int left1 = left;
		int right1 = middle;
		int left2 = middle + 1;
		int right2 = right;
		
		for(int mergedArrayIndex = left; mergedArrayIndex <= right; mergedArrayIndex++)
		{
			if(left1 > right1 && left2 <= right2)
			{
				mergedList.set(mergedArrayIndex, list.get(left2));
				left2++;
			}
			else if(left2 > right2 && left1 <= right1)
			{
				mergedList.set(mergedArrayIndex, list.get(left1));
				left1++;
			}
			else if(comp.compare(list.get(left2), list.get(left1)) > 0)
			{
				mergedList.set(mergedArrayIndex, list.get(left1));
				left1++;
			}
			else
			{
				mergedList.set(mergedArrayIndex, list.get(left2));
				left2++;
			}
		}
		
		for(int i = left; i <= right; i++)
		{
			list.set(i, mergedList.get(i));
		}
	}
	
	public static void mergeSort(double[] array)
	{
		sort(array, 0, array.length-1);
	}
	
	private static void sort(double[] array, int left, int right)
	{
		if(left < right)
		{
			int middle = (left + right) / 2;
			
			sort(array, left, middle);
			sort(array, middle+1, right);
			
			merge(array, left, middle, right);
		}		
	}
	
	private static void merge(double[] array, int left, int middle, int right)
	{			
		double[] mergedArray = new double[array.length];
		
		int left1 = left;
		int right1 = middle;
		int left2 = middle + 1;
		int right2 = right;
		
		for(int mergedArrayIndex = left; mergedArrayIndex <= right; mergedArrayIndex++)
		{
			if(left1 > right1 && left2 <= right2)
			{
				mergedArray[mergedArrayIndex] = array[left2];
				left2++;
			}
			else if(left2 > right2 && left1 <= right1)
			{
				mergedArray[mergedArrayIndex] = array[left1];
				left1++;
			}
			else if(array[left2] > array[left1])
			{
				mergedArray[mergedArrayIndex] = array[left1];
				left1++;
			}
			else
			{
				mergedArray[mergedArrayIndex] = array[left2];
				left2++;
			}
		}
		
		System.arraycopy(mergedArray, left, array, left, right-left+1);
	}
	
	public static void mergeSort(float[] array)
	{
		sort(array, 0, array.length-1);
	}
	
	private static void sort(float[] array, int left, int right)
	{
		if(left < right)
		{
			int middle = (left + right) / 2;
			
			sort(array, left, middle);
			sort(array, middle+1, right);
			
			merge(array, left, middle, right);
		}		
	}
	
	private static void merge(float[] array, int left, int middle, int right)
	{		
		float[] mergedArray = new float[array.length];
		
		int left1 = left;
		int right1 = middle;
		int left2 = middle + 1;
		int right2 = right;
		
		for(int mergedArrayIndex = left; mergedArrayIndex <= right; mergedArrayIndex++)
		{
			if(left1 > right1 && left2 <= right2)
			{
				mergedArray[mergedArrayIndex] = array[left2];
				left2++;
			}
			else if(left2 > right2 && left1 <= right1)
			{
				mergedArray[mergedArrayIndex] = array[left1];
				left1++;
			}
			else if(array[left2] > array[left1])
			{
				mergedArray[mergedArrayIndex] = array[left1];
				left1++;
			}
			else
			{
				mergedArray[mergedArrayIndex] = array[left2];
				left2++;
			}
		}
		
		System.arraycopy(mergedArray, left, array, left, right-left+1);
	}
	
	public static void mergeSort(long[] array)
	{
		sort(array, 0, array.length-1);
	}
	
	private static void sort(long[] array, int left, int right)
	{
		if(left < right)
		{
			int middle = (left + right) / 2;
			
			sort(array, left, middle);
			sort(array, middle+1, right);
			
			merge(array, left, middle, right);
		}		
	}
	
	private static void merge(long[] array, int left, int middle, int right)
	{			
		long[] mergedArray = new long[array.length];
		
		int left1 = left;
		int right1 = middle;
		int left2 = middle + 1;
		int right2 = right;
		
		for(int mergedArrayIndex = left; mergedArrayIndex <= right; mergedArrayIndex++)
		{
			if(left1 > right1 && left2 <= right2)
			{
				mergedArray[mergedArrayIndex] = array[left2];
				left2++;
			}
			else if(left2 > right2 && left1 <= right1)
			{
				mergedArray[mergedArrayIndex] = array[left1];
				left1++;
			}
			else if(array[left2] > array[left1])
			{
				mergedArray[mergedArrayIndex] = array[left1];
				left1++;
			}
			else
			{
				mergedArray[mergedArrayIndex] = array[left2];
				left2++;
			}
		}
		
		System.arraycopy(mergedArray, left, array, left, right-left+1);
	}
	
	public static void mergeSort(int[] array)
	{
		sort(array, 0, array.length-1);
	}
	
	private static void sort(int[] array, int left, int right)
	{
		if(left < right)
		{
			int middle = (left + right) / 2;
			
			sort(array, left, middle);
			sort(array, middle+1, right);
			
			merge(array, left, middle, right);
		}		
	}
	
	private static void merge(int[] array, int left, int middle, int right)
	{		
		int[] mergedArray = new int[array.length];
		
		int left1 = left;
		int right1 = middle;
		int left2 = middle + 1;
		int right2 = right;
			
		for(int mergedArrayIndex = left; mergedArrayIndex <= right; mergedArrayIndex++)
		{
			if(left1 > right1 && left2 <= right2)
			{
				mergedArray[mergedArrayIndex] = array[left2];
				left2++;
			}
			else if(left2 > right2 && left1 <= right1)
			{
				mergedArray[mergedArrayIndex] = array[left1];
				left1++;
			}
			else if(array[left2] > array[left1])
			{
				mergedArray[mergedArrayIndex] = array[left1];
				left1++;
			}
			else
			{
				mergedArray[mergedArrayIndex] = array[left2];
				left2++;
			}
		}
		
		System.arraycopy(mergedArray, left, array, left, right-left+1);
	}
	
	public static void mergeSort(short[] array)
	{
		sort(array, 0, array.length-1);
	}
	
	private static void sort(short[] array, int left, int right)
	{
		if(left < right)
		{
			int middle = (left + right) / 2;
			
			sort(array, left, middle);
			sort(array, middle+1, right);
			
			merge(array, left, middle, right);
		}		
	}
	
	private static void merge(short[] array, int left, int middle, int right)
	{		
		short[] mergedArray = new short[array.length];
		
		int left1 = left;
		int right1 = middle;
		int left2 = middle + 1;
		int right2 = right;
		
		for(int mergedArrayIndex = left; mergedArrayIndex <= right; mergedArrayIndex++)
		{
			if(left1 > right1 && left2 <= right2)
			{
				mergedArray[mergedArrayIndex] = array[left2];
				left2++;
			}
			else if(left2 > right2 && left1 <= right1)
			{
				mergedArray[mergedArrayIndex] = array[left1];
				left1++;
			}
			else if(array[left2] > array[left1])
			{
				mergedArray[mergedArrayIndex] = array[left1];
				left1++;
			}
			else
			{
				mergedArray[mergedArrayIndex] = array[left2];
				left2++;
			}
		}
		
		System.arraycopy(mergedArray, left, array, left, right-left+1);
	}
	
	public static void mergeSort(char[] array)
	{
		sort(array, 0, array.length-1);
	}
	
	private static void sort(char[] array, int left, int right)
	{
		if(left < right)
		{
			int middle = (left + right) / 2;
			
			sort(array, left, middle);
			sort(array, middle+1, right);
			
			merge(array, left, middle, right);
		}		
	}
	
	private static void merge(char[] array, int left, int middle, int right)
	{			
		char[] mergedArray = new char[array.length];
		
		int left1 = left;
		int right1 = middle;
		int left2 = middle + 1;
		int right2 = right;
		
		for(int mergedArrayIndex = left; mergedArrayIndex <= right; mergedArrayIndex++)
		{
			if(left1 > right1 && left2 <= right2)
			{
				mergedArray[mergedArrayIndex] = array[left2];
				left2++;
			}
			else if(left2 > right2 && left1 <= right1)
			{
				mergedArray[mergedArrayIndex] = array[left1];
				left1++;
			}
			else if(array[left2] > array[left1])
			{
				mergedArray[mergedArrayIndex] = array[left1];
				left1++;
			}
			else
			{
				mergedArray[mergedArrayIndex] = array[left2];
				left2++;
			}
		}
		
		System.arraycopy(mergedArray, left, array, left, right-left+1);
	}
}
