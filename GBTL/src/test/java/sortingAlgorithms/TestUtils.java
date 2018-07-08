package sortingAlgorithms;

import java.util.Random;

public class TestUtils
{
	private static Random random = new Random();
	
	public static int[] createRandomArray_int(int arraySize, int min, int max)
	{	
		int[] array = new int[arraySize];
		
		for(int i = 0; i < arraySize; i++)
		{
			array[i] = random.nextInt(max-min) + min;
		}
		
		return array;
	}
	
	public static int[] createRandomArray_int(int arraySize)
	{	
		int[] array = new int[arraySize];
		
		for(int i = 0; i < arraySize; i++)
		{
			array[i] = random.nextInt();
		}
		
		return array;
	}
		
	public static long[] createRandomArray_long(int arraySize)
	{	
		long[] array = new long[arraySize];
		
		for(int i = 0; i < arraySize; i++)
		{
			array[i] = random.nextLong();
		}
		
		return array;
	}

	public static float[] createRandomArray_float(int arraySize)
	{	
		float[] array = new float[arraySize];
		
		for(int i = 0; i < arraySize; i++)
		{
			array[i] = random.nextFloat();
		}
		
		return array;
	}
	
	public static double[] createRandomArray_double(int arraySize)
	{	
		double[] array = new double[arraySize];
		
		for(int i = 0; i < arraySize; i++)
		{
			array[i] = random.nextDouble();
		}
		
		return array;
	}
	
	public static short[] createRandomArray_short(int arraySize, short min, short max)
	{	
		short[] array = new short[arraySize];
		
		for(int i = 0; i < arraySize; i++)
		{
			array[i] = (short) (random.nextInt(max-min) + min);
		}
		
		return array;
	}
	
	public static short[] createRandomArray_short(int arraySize)
	{	
		short[] array = new short[arraySize];
		
		for(int i = 0; i < arraySize; i++)
		{
			array[i] = (short) random.nextInt(Short.MAX_VALUE);
		}

		return array;
	}
	
	public static char[] createRandomArray_char(int arraySize, char min, char max)
	{	
		char[] array = new char[arraySize];
		
		for(int i = 0; i < arraySize; i++)
		{
			array[i] = (char) (random.nextInt(max-min) + min);
		}
		
		return array;
	}
	
	public static char[] createRandomArray_char(int arraySize)
	{	
		char[] array = new char[arraySize];
		
		for(int i = 0; i < arraySize; i++)
		{
			array[i] = (char) random.nextInt(65_535);
		}
		
		return array;
	}
}
