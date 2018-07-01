package sortingAlgorithms;

public class MergeSort 
{
	public static void Mergesort(int[] array, int left, int right, int arraySize)
	{
		if(left < right)
		{
			int middle = (left + right) / 2;
			
			Mergesort(array, left, middle, arraySize);
			Mergesort(array, middle+1, right, arraySize);
			
			merge(array, left, middle, right, arraySize);
		}
		
	}
	
	public static void merge(int[] array, int left, int middle, int right, int arraySize)
	{
		int []mergedArray = new int[arraySize];
		
		int left1 = left;
		int right1 = middle;
		int left2 = middle + 1;
		int right2 = right;
		
		int mergedArrayIndex = left;
		
		while(mergedArrayIndex <= right)
		{
			if(left1 > right1 && left2 <= right2)
			{
				mergedArray[mergedArrayIndex] = array[left2];
				left2++;
				mergedArrayIndex++;
				continue;
			}
			else if(left2 > right2 && left1 <= right1)
			{
				mergedArray[mergedArrayIndex] = array[left1];
				left1++;
				mergedArrayIndex++;
				continue;
			}
			
			if(array[left1] < array[left2])
			{
				mergedArray[mergedArrayIndex] = array[left1];
				left1++;
				mergedArrayIndex++;
			}
			else
			{
				mergedArray[mergedArrayIndex] = array[left2];
				left2++;
				mergedArrayIndex++;
			}
		}
		
		for(int i = left; i <= right; i++)
		{
			array[i] = mergedArray[i];
		}
	}
}
