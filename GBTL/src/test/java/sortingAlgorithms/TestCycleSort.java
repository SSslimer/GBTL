package sortingAlgorithms;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class TestCycleSort 
{
	@Test
	public void testPrimitiveType()
	{
		double[] array_double = TestUtils.createRandomArray_double(1000);
		double[] array2_double = array_double.clone();
		
		Arrays.sort(array2_double);
		CycleSort.cycleSort(array_double);
		
		for(int i = 0; i < array_double.length; i++)
		{
			assertEquals(array_double[i], array2_double[i], 0.00001);
		}
		
		//////////////////////////////////////////////////
		
		float[] array_float = TestUtils.createRandomArray_float(1000);
		float[] array2_float = array_float.clone();
		
		Arrays.sort(array2_float);
		CycleSort.cycleSort(array_float);
		
		for(int i = 0; i < array_float.length; i++)
		{
			assertEquals(array_float[i], array2_float[i], 0.00001);
		}
		
		//////////////////////////////////////////////////
		
		long[] array_long = TestUtils.createRandomArray_long(1000);
		long[] array2_long = array_long.clone();
		
		Arrays.sort(array2_long);
		CycleSort.cycleSort(array_long);
		
		for(int i = 0; i < array_long.length; i++)
		{
			assertEquals(array_long[i], array2_long[i]);
		}
		
		//////////////////////////////////////////////////
		
		int[] array_int = TestUtils.createRandomArray_int(1000, -100, 100);
		int[] array2_int = array_int.clone();
		
		Arrays.sort(array2_int);
		CycleSort.cycleSort(array_int);
		
		for(int i = 0; i < array_int.length; i++)
		{
			assertEquals(array_int[i], array2_int[i]);
		}
		
		//////////////////////////////////////////////////
		
		short[] array_short = TestUtils.createRandomArray_short(1000);
		short[] array2_short = array_short.clone();
		
		Arrays.sort(array2_short);
		CycleSort.cycleSort(array_short);
		
		for(int i = 0; i < array_short.length; i++)
		{
			assertEquals(array_short[i], array2_short[i]);
		}
		
		//////////////////////////////////////////////////
		
		char[] array_char = TestUtils.createRandomArray_char(1000);
		char[] array2_char = array_char.clone();
		
		Arrays.sort(array2_char);
		CycleSort.cycleSort(array_char);
		
		for(int i = 0; i < array_char.length; i++)
		{
			assertEquals(array_char[i], array2_char[i]);
		}
	}
	
	@Test
	public void testGeneric()
	{
		List<Integer> list = TestUtils.createRandomIntegerList(1000);
		List<Integer> list2 = new ArrayList<>(1000);
		for(int i = 0; i < list.size(); i++) list2.add(list.get(i));

		CycleSort.cycleSort(list);
		list2.sort(new Comparator<Integer>()
		{
			@Override
			public int compare(Integer o1, Integer o2)
			{
				return o1.compareTo(o2);
			}
		});		
		
		for(int i = 0; i < list.size(); i++)
		{
			assertEquals(list.get(i), list2.get(i));
		}
		
		//////////////////////////////////////////////////
		
		list = TestUtils.createRandomIntegerList(1000);
		list2 = new ArrayList<>(1000);
		for(int i = 0; i < list.size(); i++) list2.add(list.get(i));

		CycleSort.cycleSort(list, new Comparator<Integer>()
		{
			@Override
			public int compare(Integer o1, Integer o2)
			{
				return o1.compareTo(o2);
			}
		});
		list2.sort(new Comparator<Integer>()
		{
			@Override
			public int compare(Integer o1, Integer o2)
			{
				return o1.compareTo(o2);
			}
		});		
		
		for(int i = 0; i < list.size(); i++)
		{
			assertEquals(list.get(i), list2.get(i));
		}
		
		//////////////////////////////////////////////////
		
		Integer[] array = TestUtils.createRandomIntegerArray(1000);
		Integer[] array2 = array.clone();

		CycleSort.cycleSort(array);
		Arrays.sort(array2);	
		
		for(int i = 0; i < list.size(); i++)
		{
			assertEquals(array[i], array2[i]);
		}
		
		//////////////////////////////////////////////////
		
		array = TestUtils.createRandomIntegerArray(1000);
		array2 = array.clone();

		CycleSort.cycleSort(array, new Comparator<Integer>()
		{
			@Override
			public int compare(Integer o1, Integer o2)
			{
				return o1.compareTo(o2);
			}
		});
		Arrays.sort(array2, new Comparator<Integer>()
		{
			@Override
			public int compare(Integer o1, Integer o2)
			{
				return o1.compareTo(o2);
			}
		});	
		
		for(int i = 0; i < list.size(); i++)
		{
			assertEquals(array[i], array2[i]);
		}
		
		//////////////////////////////////////////////////
	}
}
