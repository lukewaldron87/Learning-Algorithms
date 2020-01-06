package algo.quicksort;

import java.util.Arrays;
import java.util.List;

public class PracticeApp {

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
	 * @param start - starting point (first value)
	 * @param end - pivot value (end value)
	 */
	private static void quickSort(int[] inputArray, int low, int high) {
		
		// repeat until at the end of the array
		if( low < high ) {
			
			// partition the array and 
			// place all elements smaller than the pivot value to the left and 
			// all bigger values to the right
			int pivotIndex = partition(inputArray, low, high);
			// split the array either side of the pivot index
			quickSort(inputArray, low, pivotIndex-1);
			quickSort(inputArray, pivotIndex+1, high);
		}
		
	}
	
	/**
	 * place values smaller then the partition on the left side of the array and values greater than on the right side
	 * 
	 * @param inputArray
	 * @param start - starting point (first value)
	 * @param end - pivot value (end value)
	 * @return position of sorted element (pivot position)
	 */
	private static int partition(int[] inputArray, int low, int high) {
		
		// save the pivot value
		int pivot = inputArray[high];
		
		// set index of lowest value
		int i = low;
		
		// loop through the array from low to high
		for(int j=low; j<high; j++) {
			
			// check if the current element is less than the pivot point
			// move values lees than the pivot to the left half of the array
			if(inputArray[j] < pivot) {
				// swap the element with the index of the lowest value
				// and increment the low value index
				int temp = inputArray[i];
				inputArray[i] = inputArray[j];
				inputArray[j] = temp;
				i++;
			}
			
		}
		
		// swap the pivot element with the low value index
		inputArray[high] = inputArray[i];
		inputArray[i] = pivot;
		
		return i;
	}
	
}
