package sortingAlgorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HeapSort 
{
	public static <T extends Comparable<T>> void heapSort(T[] array)
	{
		T[] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);

		int size = array.length;
		
		for(int i = 0; i < array.length; i++, size--)
		{
			createHeap(array, size);
			newArray[size-1] = array[0];
			
			SortUtils.swap(array, 0, size-1);	
		}
		
		for(int i = array.length-1; i >= 0 ; i--)
		{
			array[i] = newArray[i];
		}
	}
	
	private static <T extends Comparable<T>> void createHeap(T[] array, int size)
	{
		T[] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);
		
		for(int i = 0; i < size; i++)
		{
			newArray[i] = array[i];
			int j = i;
			
			while(j > 0)
			{
				int parentIndex = (j - (j%2 == 0 ? 2 : 1)) / 2;
				
				if(newArray[j].compareTo(newArray[parentIndex]) > 0)
				{
					SortUtils.swap(newArray, parentIndex, j);
					j = parentIndex;
				}
				else break;
			}		
		}
		
		for(int i = size-1; i >= 0; i--)
		{
			array[i] = newArray[i];
		}
	}
	
	public static <T> void heapSort(T[] array, Comparator<T> comp)
	{
		T[] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);
		
		int size = array.length;
		
		for(int i = 0; i < array.length; i++, size--)
		{
			createHeap(array, size, comp);
			newArray[size-1] = array[0];
			
			SortUtils.swap(array, 0, size-1);	
		}
		
		for(int i = array.length-1; i >= 0 ; i--)
		{
			array[i] = newArray[i];
		}
	}
	
	private static <T> void createHeap(T[] array, int size, Comparator<T> comp)
	{
		T[] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);
		
		for(int i = 0; i < size; i++)
		{
			newArray[i] = array[i];
			int j = i;
			
			while(j > 0)
			{
				int parentIndex = (j - (j%2 == 0 ? 2 : 1)) / 2;
				
				if(comp.compare(newArray[j], newArray[parentIndex]) > 0)
				{
					SortUtils.swap(newArray, parentIndex, j);
					j = parentIndex;
				}
				else break;
			}		
		}
		
		for(int i = size-1; i >= 0; i--)
		{
			array[i] = newArray[i];
		}
	}
	
	public static <T extends Comparable<T>> void heapSort(List<T> list)
	{	
		List<T> newList = new ArrayList<>(list.size());
		
		int size = list.size();
		
		for(int i = 0; i < list.size(); i++, size--)
		{
			createHeap(list, size);
			newList.set(size-1, list.get(0));
			
			Collections.swap(list, 0, size-1);	
		}
		
		for(int i = list.size()-1; i >= 0; i--)
		{
			list.set(i, newList.get(i));
		}
	}
	
	private static <T extends Comparable<T>> void createHeap(List<T> list, int size)
	{		
		List<T> newList = new ArrayList<>(list.size());
		
		for(int i = 0; i < size; i++)
		{
			newList.set(i, list.get(i));
			int j = i;
			
			while(j > 0)
			{
				int parentIndex = (j - (j%2 == 0 ? 2 : 1)) / 2;
				
				if(newList.get(j).compareTo(newList.get(parentIndex)) > 0)
				{
					Collections.swap(newList, parentIndex, j);
					j = parentIndex;
				}
				else break;
			}			
		}
		
		for(int i = size-1; i >= 0; i--)
		{
			list.set(i, newList.get(i));
		}
	}
	
	public static <T> void heapSort(List<T> list, Comparator<T> comp)
	{	
		List<T> newList = new ArrayList<>(list.size());
		
		int size = list.size();
		
		for(int i = 0; i < list.size(); i++, size--)
		{
			createHeap(list, size, comp);
			newList.set(size-1, list.get(0));
			
			Collections.swap(list, 0, size-1);	
		}
		
		for(int i = list.size()-1; i >= 0; i--)
		{
			list.set(i, newList.get(i));
		}
	}
	
	private static <T> void createHeap(List<T> list, int size, Comparator<T> comp)
	{		
		List<T> newList = new ArrayList<>(list.size());
		
		for(int i = 0; i < size; i++)
		{
			newList.set(i, list.get(i));
			
			int j = i;
			
			while(j > 0)
			{
				int parentIndex = (j - (j%2 == 0 ? 2 : 1)) / 2;
				
				if(comp.compare(newList.get(j), newList.get(parentIndex)) > 0)
				{
					Collections.swap(newList, parentIndex, j);
					j = parentIndex;
				}
				else break;
			}			
		}
		
		for(int i = size-1; i >= 0; i--)
		{
			list.set(i, newList.get(i));
		}
	}
	
	public static void heapSort(double[] array)
	{
		double[] newArray = new double[array.length];
		
		int size = array.length;
		
		for(int i = 0; i < array.length; i++, size--)
		{
			createHeap(array, size);
			newArray[size-1] = array[0];
			
			SortUtils.swap(array, 0, size-1);	
		}
		
		for(int i = array.length-1; i >= 0; i--)
		{
			array[i] = newArray[i];
		}
	}
	
	private static void createHeap(double[] array, int size)
	{
		double[] newArray = new double[array.length];
		
		for(int i = 0; i < size; i++)
		{
			newArray[i] = array[i];
			int j = i;
			
			while(j > 0)
			{
				int parentIndex = (j - (j%2 == 0 ? 2 : 1)) / 2;
				
				if(newArray[j] > newArray[parentIndex])
				{
					SortUtils.swap(newArray, parentIndex, j);
					j = parentIndex;
				}
				else break;
			}
		}
		
		for(int i = size-1; i >= 0; i--)
		{
			array[i] = newArray[i];
		}
	}
	
	public static void heapSort(float[] array)
	{
		float[] newArray = new float[array.length];
		
		int size = array.length;
		
		for(int i = 0; i < array.length; i++, size--)
		{
			createHeap(array, size);
			newArray[size-1] = array[0];
			
			SortUtils.swap(array, 0, size-1);	
		}
		
		for(int i = array.length-1; i >= 0; i--)
		{
			array[i] = newArray[i];
		}
	}
	
	private static void createHeap(float[] array, int size)
	{
		float[] newArray = new float[array.length];
		
		for(int i = 0; i < size; i++)
		{
			newArray[i] = array[i];
			int j = i;
			
			while(j > 0)
			{
				int parentIndex = (j - (j%2 == 0 ? 2 : 1)) / 2;
				
				if(newArray[j] > newArray[parentIndex])
				{
					SortUtils.swap(newArray, parentIndex, j);
					j = parentIndex;
				}
				else break;
			}
			
		}
		
		for(int i = size-1; i >= 0; i--)
		{
			array[i] = newArray[i];
		}
	}
	
	public static void heapSort(long[] array)
	{
		long[] newArray = new long[array.length];
		
		int size = array.length;
		
		for(int i = 0; i < array.length; i++, size--)
		{
			createHeap(array, size);
			newArray[size-1] = array[0];
			
			SortUtils.swap(array, 0, size-1);	
		}
		
		for(int i = array.length-1; i >= 0; i--)
		{
			array[i] = newArray[i];
		}
	}
	
	private static void createHeap(long[] array, int size)
	{
		long[] newArray = new long[array.length];
		
		for(int i = 0; i < size; i++)
		{
			newArray[i] = array[i];
			int j = i;
			
			while(j > 0)
			{
				int parentIndex = (j - (j%2 == 0 ? 2 : 1)) / 2;
				
				if(newArray[j] > newArray[parentIndex])
				{
					SortUtils.swap(newArray, parentIndex, j);
					j = parentIndex;
				}
				else break;
			}			
		}
		
		for(int i = size-1; i >= 0; i--)
		{
			array[i] = newArray[i];
		}
	}
	
	public static void heapSort(int[] array)
	{
		int[] newArray = new int[array.length];
		
		int size = array.length;
		
		for(int i = 0; i < array.length; i++, size--)
		{
			createHeap(array, size);
			newArray[size-1] = array[0];
			
			SortUtils.swap(array, 0, size-1);	
		}
		
		for(int i = array.length-1; i >= 0; i--)
		{
			array[i] = newArray[i];
		}
	}
	
	private static void createHeap(int[] array, int size)
	{
		int[] newArray = new int[array.length];
		
		for(int i = 0; i < size; i++)
		{
			newArray[i] = array[i];
			int j = i;
			
			while(j > 0)
			{
				int parentIndex = (j - (j%2 == 0 ? 2 : 1)) / 2;
				
				if(newArray[j] > newArray[parentIndex])
				{
					SortUtils.swap(newArray, parentIndex, j);
					j = parentIndex;
				}
				else break;
			}			
		}
		
		for(int i = size-1; i >= 0; i--)
		{
			array[i] = newArray[i];
		}
	}
	
	public static void heapSort(short[] array)
	{
		short[] newArray = new short[array.length];
		
		int size = array.length;
		
		for(int i = 0; i < array.length; i++, size--)
		{
			createHeap(array, size);
			newArray[size-1] = array[0];
			
			SortUtils.swap(array, 0, size-1);	
		}
		
		for(int i = array.length-1; i >= 0; i--)
		{
			array[i] = newArray[i];
		}
	}
	
	private static void createHeap(short[] array, int size)
	{
		short[] newArray = new short[array.length];
		
		for(int i = 0; i < size; i++)
		{
			newArray[i] = array[i];
			int j = i;
			
			while(j > 0)
			{
				int parentIndex = (j - (j%2 == 0 ? 2 : 1)) / 2;
				
				if(newArray[j] > newArray[parentIndex])
				{
					SortUtils.swap(newArray, parentIndex, j);
					j = parentIndex;
				}
				else break;
			}		
		}
		
		for(int i = size-1; i >= 0; i--)
		{
			array[i] = newArray[i];
		}
	}
	
	public static void heapSort(char[] array)
	{
		char[] newArray = new char[array.length];
		
		int size = array.length;
		
		for(int i = 0; i < array.length; i++, size--)
		{
			createHeap(array, size);
			newArray[size-1] = array[0];
			
			SortUtils.swap(array, 0, size-1);	
		}
		
		for(int i = array.length-1; i >= 0; i--)
		{
			array[i] = newArray[i];
		}
	}
	
	private static void createHeap(char[] array, int size)
	{
		char[] newArray = new char[array.length];
		
		for(int i = 0; i < size; i++)
		{
			newArray[i] = array[i];
			int j = i;
			
			while(j > 0)
			{
				int parentIndex = (j - (j%2 == 0 ? 2 : 1)) / 2;
				
				if(newArray[j] > newArray[parentIndex])
				{
					SortUtils.swap(newArray, parentIndex, j);
					j = parentIndex;
				}
				else break;
			}			
		}
		
		for(int i = size-1; i >= 0; i--)
		{
			array[i] = newArray[i];
		}
	}
}
