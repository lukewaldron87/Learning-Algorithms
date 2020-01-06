package algo.mergesort; 

public class PracticeMergeSort {
	
	public void sort(int[] inputArray) {
		
		mergeSort(inputArray, 0, inputArray.length-1);
		
	}
	
	private void mergeSort(int[] inputArray, int min, int max) {
		
		// only sort if not at the end of the array
		if(min < max) {
			
			// split the array in two
			int midpoint = (min+max)/2;
			mergeSort(inputArray, min, midpoint);
			mergeSort(inputArray, midpoint+1, max);
			
			// merge and sort arrays
			merge(inputArray, min, midpoint, max);
			
		}
		
	}
	
	private void merge(int[] inputArray, int min, int mid, int max) {
		
		// get the length of the two arrays 
		int leftArrayLength = (mid-min)+1;
		int rightArrayLength = max-mid;
		
		int[] leftArray = new int[leftArrayLength];
		int[] rightArray = new int[rightArrayLength];
		
		// fill the left and right arrays
		for(int i=0; i<leftArrayLength; i++) {
			leftArray[i] = inputArray[min+i];
		}
		
		for(int i=0; i<rightArray.length; i++) {
			rightArray[i] = inputArray[mid+i+1];
		}
		

		// merge arrays
		int leftArrayIndex = 0;
		int rightArrayIndex = 0;
		
		int inputArrayIndex = min;
		
		while( leftArrayIndex < leftArrayLength && rightArrayIndex < rightArrayLength) {
			
			// place the element with the lowest value in the inputArray
			if( leftArray[leftArrayIndex] < rightArray[rightArrayIndex]) {
				inputArray[inputArrayIndex] = leftArray[leftArrayIndex];
				leftArrayIndex++;
			}else {
				inputArray[inputArrayIndex] = rightArray[rightArrayIndex];
				rightArrayIndex++;
			}
			
			inputArrayIndex++;
			
		}
		
		// get the remaining elements form the left and right arrays
		while( leftArrayIndex < leftArrayLength ) {
			inputArray[inputArrayIndex] = leftArray[leftArrayIndex];
			leftArrayIndex++;
			inputArrayIndex++;
		}
		
		while( rightArrayIndex < rightArrayLength ) {
			inputArray[inputArrayIndex] = rightArray[rightArrayIndex];
			rightArrayIndex++;
			inputArrayIndex++;
		}
		
	}
	
}
