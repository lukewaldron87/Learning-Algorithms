package algo.mergesort; 

public class PracticeMergeSort {
	
	public void sort(int[] inputArray) {
		
		// pass inputArray  and it's start and end indexes 
		// to recursive sort
		sort(inputArray, 0, inputArray.length-1);
		
	}
	
	private void sort(int[] inputArray, int start, int end) {
		
		// return when at the end of the array
		if(start >= end) {
			return;
		}
		
		// get the midpoint of the inputArray
		int midpoint = (start + end) /2;
		
		//split the array into left and right arrays
		sort(inputArray, start, midpoint);
		sort(inputArray, midpoint+1, end);
		
		// sort and merge the left and right arrays
		merge(inputArray, start, midpoint, end);
		
	}
	
	/**
	 * create two arrays for the left and right elements
	 * sort and merge these array into the input array
	 * 
	 * @param inputArray
	 * @param start
	 * @param mid
	 * @param end
	 */
	private void merge(int[] inputArray, int start, int mid, int end) {
		
		// get the length of the left and right arrays
		int leftArrayLength = (mid-start)+1;
		int rightArrayLength = end-mid;
		
		// create the left and right arrays
		int[] leftArray = new int[leftArrayLength];
		int[] rightArray = new int[rightArrayLength];
		
		// populate the left and right arrays
		for(int i=0; i<leftArrayLength; i++) {
			leftArray[i] = inputArray[start+i];
		}
		
		for(int i=0; i<rightArrayLength; i++) {
			rightArray[i] = inputArray[mid+i+1];
		}
		
		// MERGE ARRAYS
		// create array indexes
		int leftArrayIndex = 0;
		int rightArrayIndex = 0;
		int inputArrayIndex = start;
		
		// loop through the left and right arrays
		// sort and merge them into the into array
		while( leftArrayIndex<leftArrayLength && rightArrayIndex<rightArrayLength) {
			
			// if the current leftArray element
			// is less than the current right array element
			if( leftArray[leftArrayIndex] < rightArray[rightArrayIndex]) {
				
				// add the current left array element to the input array
				inputArray[inputArrayIndex] = leftArray[leftArrayIndex];
				leftArrayIndex++;
				
			}else {
				
				//otherwise add the current rightArray element to the input array
				inputArray[inputArrayIndex] = rightArray[rightArrayIndex];
				rightArrayIndex++;
				
			}
			
			inputArrayIndex++;
		}
		
		// add any remaining elements
		// from the right or left arrays 
		// to the input array
		while( leftArrayIndex<leftArrayLength ) {

			inputArray[inputArrayIndex] = leftArray[leftArrayIndex];
			leftArrayIndex++;
			inputArrayIndex++;
			
		}
		
		while( rightArrayIndex<rightArrayLength ) {
			
			inputArray[inputArrayIndex] = rightArray[rightArrayIndex];
			rightArrayIndex++;
			inputArrayIndex++;
			
		}
		
	}
	
}
