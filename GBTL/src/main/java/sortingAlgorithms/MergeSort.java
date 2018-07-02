package sortingAlgorithms;

public class MergeSort 
{
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
