package sortingAlgorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CycleSort 
{
	public static<T extends Comparable<T>> void cycleSort(T[] array)
	{
		T [] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);
		
		for(int i = 0; i < array.length; i++)
		{	
			int pos = 0;
			T item = array[i];
				
			for(int j = 0; j < array.length; j++)
			{
				if(item.compareTo(array[j]) > 0)
				{
					pos++;
				}
			}
			
			while(newArray[pos] != null) 
			{
				pos++;
			}
			
			newArray[pos] = array[i];
			
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);	
	}
	
	public static<T> void cycleSort(T[] array, Comparator<T> comp)
	{
		T [] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);
		
		for(int i = 0; i < array.length; i++)
		{	
			int pos = 0;
			T item = array[i];
				
			for(int j = 0; j < array.length; j++)
			{
				if(comp.compare(item, array[j]) > 0)
				{
					pos++;
				}
			}
			
			while(newArray[pos] != null) 
			{
				pos++;
			}
			
			newArray[pos] = array[i];
			
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);	
	}
	
	public static<T extends Comparable<T>> void cycleSort(List<T> list)
	{
		List<T> newList = new ArrayList<>(list.size());
		
		for(int i = 0; i < list.size(); i++)
		{
			newList.add(list.get(i));
		}
		
		boolean [] wasPlaced = new boolean[list.size()];
		
		for(int i = 0; i < list.size(); i++)
		{	
			int pos = 0;
			T item = list.get(i);
				
			for(int j = 0; j < list.size(); j++)
			{
				if(item.compareTo(list.get(j)) > 0)
				{
					pos++;
				}
			}
			
			while(wasPlaced[pos])
			{
				pos++;
			}
			
			newList.set(pos, list.get(i));
			wasPlaced[pos] = true;
			
		}
		
		for(int i = list.size()-1; i >= 0; i--)
		{
			list.set(i, newList.get(i));
		}	
	}
	
	public static<T> void cycleSort(List<T> list, Comparator<T> comp)
	{
		List<T> newList = new ArrayList<>(list.size());
		
		for(int i = 0; i < list.size(); i++)
		{
			newList.add(list.get(i));
		}
		
		boolean [] wasPlaced = new boolean[list.size()];
		
		for(int i = 0; i < list.size(); i++)
		{	
			int pos = 0;
			T item = list.get(i);
				
			for(int j = 0; j < list.size(); j++)
			{
				if(comp.compare(item, list.get(j)) > 0)
				{
					pos++;
				}
			}
			
			while(wasPlaced[pos]) 
			{
				pos++;
			}
			
			newList.set(pos, list.get(i));
			wasPlaced[pos] = true;
		}
		
		for(int i = list.size()-1; i >= 0; i--)
		{
			list.set(i, newList.get(i));
		}	
	}
	
	public static void cycleSort(double[] array)
	{
		double [] newArray = new double[array.length];
		boolean [] wasPlaced = new boolean[array.length];
		
		for(int i = 0; i < array.length; i++)
		{	
			int pos = 0;
			double item = array[i];
				
			for(int j = 0; j < array.length; j++)
			{
				if(item > array[j])
				{
					pos++;
				}
			}
			
			while(wasPlaced[pos]) 
			{
				pos++;
			}
			
			newArray[pos] = array[i];
			wasPlaced[pos] = true;
			
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);	
	}
	
	public static void cycleSort(float[] array)
	{
		float [] newArray = new float[array.length];
		boolean [] wasPlaced = new boolean[array.length];
		
		for(int i = 0; i < array.length; i++)
		{	
			int pos = 0;
			float item = array[i];
				
			for(int j = 0; j < array.length; j++)
			{
				if(item > array[j])
				{
					pos++;
				}
			}
			
			while(wasPlaced[pos]) 
			{
				pos++;
			}
			
			newArray[pos] = array[i];
			wasPlaced[pos] = true;
			
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);	
	}
	
	public static void cycleSort(long[] array)
	{
		long [] newArray = new long[array.length];
		boolean [] wasPlaced = new boolean[array.length];
		
		for(int i = 0; i < array.length; i++)
		{	
			int pos = 0;
			long item = array[i];
				
			for(int j = 0; j < array.length; j++)
			{
				if(item > array[j])
				{
					pos++;
				}
			}
			
			while(wasPlaced[pos]) 
			{
				pos++;
			}
			
			newArray[pos] = array[i];
			wasPlaced[pos] = true;
			
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);	
	}
	
	public static void cycleSort(int[] array)
	{
		int [] newArray = new int[array.length];
		boolean [] wasPlaced = new boolean[array.length];
		
		for(int i = 0; i < array.length; i++)
		{	
			int pos = 0;
			int item = array[i];
				
			for(int j = 0; j < array.length; j++)
			{
				if(item > array[j])
				{
					pos++;
				}
			}
			
			while(wasPlaced[pos]) 
			{
				pos++;
			}
			
			newArray[pos] = array[i];
			wasPlaced[pos] = true;
			
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);	
	}
	
	public static void cycleSort(short[] array)
	{
		short [] newArray = new short[array.length];
		boolean [] wasPlaced = new boolean[array.length];
		
		for(int i = 0; i < array.length; i++)
		{	
			int pos = 0;
			short item = array[i];
				
			for(int j = 0; j < array.length; j++)
			{
				if(item > array[j])
				{
					pos++;
				}
			}
			
			while(wasPlaced[pos]) 
			{
				pos++;
			}
			
			newArray[pos] = array[i];
			wasPlaced[pos] = true;
			
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);	
	}
	
	public static void cycleSort(char[] array)
	{
		char [] newArray = new char[array.length];
		boolean [] wasPlaced = new boolean[array.length];
		
		for(int i = 0; i < array.length; i++)
		{	
			int pos = 0;
			char item = array[i];
				
			for(int j = 0; j < array.length; j++)
			{
				if(item > array[j])
				{
					pos++;
				}
			}
			
			while(wasPlaced[pos]) 
			{
				pos++;
			}
			
			newArray[pos] = array[i];
			wasPlaced[pos] = true;
			
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);	
	}
}
