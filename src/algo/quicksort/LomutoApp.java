package algo.quicksort;

import java.util.Arrays;
/**
 * 
 * Quick Sort is a divide and conquer algorithm.
 * It creates two empty arrays to hold elements less than the pivot value and elements greater than the pivot value, and then recursively sort the sub arrays.
 * There are two basic operations in the algorithm, swapping items in place and partitioning a section of the array
 * 
 * no new arrays are created
 * 
 * items smaller than the pivot are placed to the left of it 
 * items larger than the pivot are place to the right of it 
 * 
 * @author Luke Waldron
 *
 */

public class LomutoApp {

	public static void main(String[] args) {
		
		
		int[] inputArray = {12,81,74,43,1098,0,8,92,17,754,912,0,6,4};
		quickSort(inputArray, 0, inputArray.length-1);
		
		System.out.println(Arrays.toString(inputArray));

	}

	/**
	 * partitions array and passes the sub arrays into itself 
	 * 
	 * divide up the array into two sub arrays.
	 * One containing values less than the partition value r
	 * and one containing values greater than partition value r

	 * 
	 * @param inputArray 
	 * @param low - highing point (first value)
	 * @param end - pivot value (end value)
	 */
	private static void quickSort(int[] inputArray, int low, int high) {

		// if the sub array
		if(low<high) {
			int pivotIndex = partition(inputArray, low, high);
			// sorts left half of the range
			quickSort(inputArray, low, pivotIndex-1);
			// sorts right half of the range
			quickSort(inputArray, pivotIndex+1, high);
		}
		
	}
	
	/**
	 * place values smaller then the partition on the left side of the array and values greater than on the right side
	 * 
	 * @param inputArray
	 * @param low - starting point (first value)
	 * @param high - pivot value (end value)
	 * @return position of sorted element (pivot position)
	 */
	private static int partition(int[] inputArray, int low, int high) {
		
		int pivot = inputArray[high];
		// get the starting point 
		int i = low;
		int temp = 0;
		
		// loop until you get to the pivot value
		for(int j=low; j<high; j++) {
		
			
			// if less than the pivot value
			if(inputArray[j] < pivot) {
				// swap the values at index i and j
				temp = inputArray[j];
				inputArray[j] = inputArray[i];
				inputArray[i] = temp;
				// increase the first index
				i++;
			}
			
		}
		
		// swap j+1 (high) with i+1 to put end in the pivot point
		//temp = inputArray[high];
		inputArray[high] = inputArray[i];
		inputArray[i] = pivot;
		
		// return the pivot position
		return i;
	}
	
	/**
	 * place values smaller then the partition on the left side of the array and values greater than on the right side
	 * 
	 * @param inputArray
	 * @param low - starting point (first value)
	 * @param high - pivot value (end value)
	 * @return position of sorted element (pivot position)
	 */
	/*private static int partition(int[] inputArray, int low, int high) {
		
		int pivot = inputArray[high];
		// get the starting point 
		int i = low-1;
		int temp = 0;
		
		// loop until you get to the pivot value
		for(int j=low; j<high; j++) {
		
			
			// if less than the pivot value
			if(inputArray[j] < pivot) {
				// increase the first index
				i++;
				// swap the values at index i and j
				temp = inputArray[j];
				inputArray[j] = inputArray[i];
				inputArray[i] = temp;
			}
			
		}
		
		// swap j+1 (high) with i+1 to put end in the pivot point
		//temp = inputArray[high];
		inputArray[high] = inputArray[i+1];
		inputArray[i+1] = pivot;
		
		// return the pivot position
		return i+1;
	}*/
	


}
