package sortingAlgorithms;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertionSort 
{
	public static<T extends Comparable<T>> void insertionSort(T[] array)
	{	
		@SuppressWarnings("unchecked")
		T[] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);
		
		newArray[0] = array[0];
		
		for(int i = 1; i < array.length; i++)
		{
			newArray[i] = array[i];
			
			for(int j = i - 1; j >= 0; j--)
			{			
				int k = j+1;
				T x = newArray[j];
				T y = newArray[k];

				if(x.compareTo(y) > 0) SortUtils.swap(newArray, j, k);
				else break;		
			}
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);		
	}
	
	public static<T> void insertionSort(T[] array, Comparator<T> comp)
	{	
		@SuppressWarnings("unchecked")
		T[] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);
		newArray[0] = array[0];
		
		for(int i = 1; i < array.length; i++)
		{
			newArray[i] = array[i];
			
			for(int j = i - 1; j >= 0; j--)
			{			
				int k = j+1;
				T x = newArray[j];
				T y = newArray[k];

				if(comp.compare(x, y) > 0) SortUtils.swap(newArray, j, k);
				else break;
			}
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);
	}
	
	public static<T extends Comparable<T>> void insertionSort(List<T> list)
	{	
		List<T> newList = new ArrayList<>(list.size());
		newList.add(0, list.get(0));
		
		for(int i = 1; i < list.size(); i++)
		{
			newList.add(i, list.get(i));
			
			for(int j = i - 1; j >= 0; j--)
			{			
				int k = j+1;

				if(newList.get(j).compareTo(newList.get(k)) > 0) Collections.swap(newList, j, k);
				else break;		
			}
		}
		
		for(int i = list.size()-1; i >= 0; i--)
		{
			list.set(i, newList.get(i));
		}		
	}
	
	public static<T> void insertionSort(List<T> list, Comparator<T> comp)
	{	
		List<T> newList = new ArrayList<>(list.size());
		newList.add(0, list.get(0));
		
		for(int i = 1; i < list.size(); i++)
		{
			newList.add(i, list.get(i));
			
			for(int j = i - 1; j >= 0; j--)
			{			
				int k = j+1;

				if(comp.compare(newList.get(j), newList.get(k)) > 0) Collections.swap(newList, j, k);
				else break;		
			}
		}
		
		for(int i = list.size()-1; i >= 0; i--)
		{
			list.set(i, newList.get(i));
		}		
	}
	
	public static void insertionSort(double[] array)
	{	
		double[] newArray = new double[array.length];
		newArray[0] = array[0];

		for(int i = 1; i < array.length; i++)
		{
			newArray[i] = array[i];
			
			for(int j = i - 1; j >= 0; j--)
			{			
				int k = j+1;

				if(newArray[j] > newArray[k]) SortUtils.swap(newArray, j, k);
				else break;
			}
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);	
	} 
	
	public static void insertionSort(float[] array)
	{	
		float[] newArray = new float[array.length];
		newArray[0] = array[0];
		
		for(int i = 1; i < array.length; i++)
		{
			newArray[i] = array[i];
			
			for(int j = i - 1; j >= 0; j--)
			{			
				int k = j+1;

				if(newArray[j] > newArray[k]) SortUtils.swap(newArray, j, k);
				else break;		
			}
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);	
	}
	
	public static void insertionSort(long[] array)
	{	
		long[] newArray = new long[array.length];
		newArray[0] = array[0];
		
		for(int i = 1; i < array.length; i++)
		{
			newArray[i] = array[i];
			
			for(int j = i - 1; j >= 0; j--)
			{			
				int k = j+1;

				if(newArray[j] > newArray[k]) SortUtils.swap(newArray, j, k);
				else break;			
			}
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);	
	}
	
	public static void insertionSort(int[] array)
	{	
		int[] newArray = new int[array.length];
		newArray[0] = array[0];
		
		for(int i = 1; i < array.length; i++)
		{
			newArray[i] = array[i];
			
			for(int j = i - 1; j >= 0; j--)
			{			
				int k = j+1;

				if(newArray[j] > newArray[k]) SortUtils.swap(newArray, j, k);
				else break;			
			}
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);	
	}
	
	public static void insertionSort(short[] array)
	{	
		short[] newArray = new short[array.length];
		newArray[0] = array[0];
		
		for(int i = 1; i < array.length; i++)
		{
			newArray[i] = array[i];
			
			for(int j = i - 1; j >= 0; j--)
			{			
				int k = j+1;

				if(newArray[j] > newArray[k]) SortUtils.swap(newArray, j, k);
				else break;			
			}
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);	
	}
	
	public static void insertionSort(char[] array)
	{	
		char[] newArray = new char[array.length];
		newArray[0] = array[0];
		
		for(int i = 1; i < array.length; i++)
		{
			newArray[i] = array[i];
			
			for(int j = i - 1; j >= 0; j--)
			{			
				int k = j+1;

				if(newArray[j] > newArray[k]) SortUtils.swap(newArray, j, k);
				else break;		
			}
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);	
	}
	
}
