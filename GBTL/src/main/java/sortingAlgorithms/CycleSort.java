package sortingAlgorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CycleSort 
{

	public static<T extends Comparable<T>> void cycleSort(T[] array)
	{
		@SuppressWarnings("unchecked")
		T [] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);
		
		for(T element : array)
		{	
			int pos = 0;
	
			for(T element2 : array)
			{
				if(element.compareTo(element2) > 0) pos++;
			}
			
			while(newArray[pos] != null) pos++;
			
			newArray[pos] = element;			
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);	
	}
	
	public static<T> void cycleSort(T[] array, Comparator<T> comp)
	{
		@SuppressWarnings("unchecked")
		T [] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);
		
		for(T element : array)
		{	
			int pos = 0;
	
			for(T element2 : array)
			{
				if(comp.compare(element, element2) > 0) pos++;
			}
			
			while(newArray[pos] != null) pos++;
		
			newArray[pos] = element;	
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);	
	}
	
	public static<T extends Comparable<T>> void cycleSort(List<T> list)
	{
		List<T> newList = new ArrayList<>(list);

		boolean[] wasPlaced = new boolean[list.size()];
		
		for(T element : list)
		{	
			int pos = 0;
	
			for(T element2 : list)
			{
				if(element.compareTo(element2) > 0) pos++;
			}
			
			while(wasPlaced[pos]) pos++;

			newList.set(pos, element);
			wasPlaced[pos] = true;	
		}
		
		for(int i = list.size()-1; i >= 0; i--)
		{
			list.set(i, newList.get(i));
		}	
	}
	
	public static<T> void cycleSort(List<T> list, Comparator<T> comp)
	{
		List<T> newList = new ArrayList<>(list);

		boolean[] wasPlaced = new boolean[list.size()];
		
		for(T element : list)
		{	
			int pos = 0;
	
			for(T element2 : list)
			{
				if(comp.compare(element, element2) > 0) pos++;
			}
			
			while(wasPlaced[pos]) pos++;

			newList.set(pos, element);
			wasPlaced[pos] = true;
		}
		
		for(int i = list.size()-1; i >= 0; i--)
		{
			list.set(i, newList.get(i));
		}	
	}
	
	public static void cycleSort(double[] array)
	{
		double[] newArray = new double[array.length];
		boolean[] wasPlaced = new boolean[array.length];
		
		for(double element : array)
		{	
			int pos = 0;
	
			for(double element2 : array)
			{
				if(element > element2) pos++;
			}
			
			while(wasPlaced[pos]) pos++;

			newArray[pos] = element;
			wasPlaced[pos] = true;
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);	
	}
	
	public static void cycleSort(float[] array)
	{
		float[] newArray = new float[array.length];
		boolean[] wasPlaced = new boolean[array.length];
		
		for(float element : array)
		{	
			int pos = 0;
	
			for(float element2 : array)
			{
				if(element > element2) pos++;
			}
			
			while(wasPlaced[pos]) pos++;
			
			newArray[pos] = element;
			wasPlaced[pos] = true;
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);	
	}
	
	public static void cycleSort(long[] array)
	{
		long[] newArray = new long[array.length];
		boolean[] wasPlaced = new boolean[array.length];
		
		for(long element : array)
		{	
			int pos = 0;

			for(long element2 : array)
			{
				if(element > element2) pos++;
			}
			
			while(wasPlaced[pos]) pos++;

			newArray[pos] = element;
			wasPlaced[pos] = true;
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);	
	}
	
	public static void cycleSort(int[] array)
	{
		int[] newArray = new int[array.length];
		boolean[] wasPlaced = new boolean[array.length];
		
		for(int element : array)
		{	
			int pos = 0;
	
			for(int element2 : array)
			{
				if(element > element2) pos++;
			}
			
			while(wasPlaced[pos]) pos++;

			newArray[pos] = element;
			wasPlaced[pos] = true;			
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);	
	}
	
	public static void cycleSort(short[] array)
	{
		short[] newArray = new short[array.length];
		boolean[] wasPlaced = new boolean[array.length];
		
		for(short element : array)
		{	
			int pos = 0;

			for(short element2 : array)
			{
				if(element > element2) pos++;
			}
			
			while(wasPlaced[pos]) pos++;

			newArray[pos] = element;
			wasPlaced[pos] = true;			
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);	
	}
	
	public static void cycleSort(char[] array)
	{
		char[] newArray = new char[array.length];
		boolean[] wasPlaced = new boolean[array.length];
		
		for(char element : array)
		{	
			int pos = 0;
	
			for(char element2 : array)
			{
				if(element > element2) pos++;
			}
			
			while(wasPlaced[pos]) pos++;
			
			newArray[pos] = element;
			wasPlaced[pos] = true;			
		}
		
		System.arraycopy(newArray, 0, array, 0, array.length);	
	}
}
