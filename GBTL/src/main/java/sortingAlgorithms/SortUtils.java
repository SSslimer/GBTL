package sortingAlgorithms;

public class SortUtils
{
	public static <T> void swap(T[] array, int i, int j)
	{
		T tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static void swap(double[] array, int i, int j)
	{
		double tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static void swap(float[] array, int i, int j)
	{
		float tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static void swap(long[] array, int i, int j)
	{
		long tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static void swap(int[] array, int i, int j)
	{
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static void swap(short[] array, int i, int j)
	{
		short tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static void swap(char[] array, int i, int j)
	{
		char tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
