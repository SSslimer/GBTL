package benchmarks;

import java.util.Random;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import sortingAlgorithms.BubbleSort;
import sortingAlgorithms.InsertionSort;

public class BenchmarkSorts
{
	private static Random random = new Random();

	public int[] createRandomIntArray(int size)
	{	
		int[] array = new int[size];
		
		for(int i = 0; i < size; i++)
		{
			array[i] = random.nextInt();
		}
		
		return array;
	}

	@Benchmark
	public void bubbleSort100(Blackhole bh)
	{
		int[] array = createRandomIntArray(100);
		BubbleSort.bubbleSort(array);
		bh.consume(array);
	}

	@Benchmark
	public void insertionSort100(Blackhole bh)
	{
		int[] array = createRandomIntArray(100);
		InsertionSort.insertionSort(array);
		bh.consume(array);
	}
	
	@Benchmark
	public void bubbleSort1000(Blackhole bh)
	{
		int[] array = createRandomIntArray(1000);
		BubbleSort.bubbleSort(array);
		bh.consume(array);
	}

	@Benchmark
	public void insertionSort1000(Blackhole bh)
	{
		int[] array = createRandomIntArray(1000);
		InsertionSort.insertionSort(array);
		bh.consume(array);
	}
	
	@Benchmark
	public void bubbleSort10000(Blackhole bh)
	{
		int[] array = createRandomIntArray(10000);
		BubbleSort.bubbleSort(array);
		bh.consume(array);
	}

	@Benchmark
	public void insertionSort10000(Blackhole bh)
	{
		int[] array = createRandomIntArray(10000);
		InsertionSort.insertionSort(array);
		bh.consume(array);
	}
}
