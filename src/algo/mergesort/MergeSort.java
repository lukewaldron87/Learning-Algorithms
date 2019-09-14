package algo.mergesort;

public class MergeSort {
	
	public void sort(int[] inputArray) {

		sort(inputArray, 0, inputArray.length-1);
		
	}
	
	public static void sort(int[] inputArray, int start, int end) {
		
		// if we reached the end of the array
		if(end <= start) {
			return;
		}
		
		int mid = (start+end)/2;
		// sort left half
		sort(inputArray, start, mid);
		// sort right half
		sort(inputArray, mid+1, end);
		// merge sorted results into the inputArray 
		merge(inputArray, start, mid, end);
		
	}
	
	// my solution attempt 2
	// based on solution from geeksforgeerks
	// https://www.geeksforgeeks.org/merge-sort/
	/***
	 * 
	 * 
	 * @param inputArray - array to be sorted
	 * @param start - starting index of section to be sorted
	 * @param mid - midpoint index of section to be sorted
	 * @param end - end index of section to be sorted
	 */
	public static void merge(int[] inputArray, int start, int mid, int end) {

		/// find size of sub arrays
		int leftArrayLength =  (mid-start) +1;
		int rightArrayLength = end-mid;
		
		// create the left and right arrays
		int[] leftSubArray = new int[leftArrayLength];
		int[] rightSubArray = new int[rightArrayLength];
		
		// populate the left and right arrays with unsorted elements
		for(int i=0; i<leftArrayLength; i++) {
			leftSubArray[i] = inputArray[start+i];
		}
		for(int j=0; j<rightArrayLength; j++) {
			rightSubArray[j] = inputArray[(mid+1)+j];
		}
		
		/* Merge the two arrays with the input array*/
		
		// Initiate indexes of left and right subarrays
		int leftIndex = 0;
		int rightIndex = 0;
		
		// Initiate index of merged subarray
		int inputArrayIndex = start;

		// sort the left and right arrays into the inputArray
		while(leftIndex < leftArrayLength && rightIndex < rightArrayLength ) {
			
			if(leftSubArray[leftIndex] <= rightSubArray[rightIndex]) {
				
				inputArray[inputArrayIndex] = leftSubArray[leftIndex];
				leftIndex++;
				
			}else {
				
				inputArray[inputArrayIndex] = rightSubArray[rightIndex];
				rightIndex++;
				
			}
			inputArrayIndex++;
			
		}
		
		// copy any remaining elements of leftSubArray if any
		while(leftIndex < leftArrayLength) {
			
			inputArray[inputArrayIndex] = leftSubArray[leftIndex];
			leftIndex++;
			inputArrayIndex++;
			
		}
		
		// copy any remaining elements of rightSubArray if any
		while(rightIndex < rightArrayLength) {
			
			inputArray[inputArrayIndex] = rightSubArray[rightIndex];
			rightIndex++;
			inputArrayIndex++;
			
		}	
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/******  Counting Inversions   *******/
	
	// Complete the countInversions function below.
	public static void main(String[] args) {

		int[] arr = {2, 1, 3, 1, 2};

		System.out.println("Expected 4 Actual " + sort(arr, 0, arr.length-1, 0) );

		for(int num: arr) {
			System.out.print(num+" ");
		}



		int[] arr2 = {7, 5, 3, 1};

		System.out.println("Expected 6 Actual " + sort(arr2, 0, arr2.length-1, 0) );

		for(int num: arr2) {
			System.out.print(num+" ");
		}

	}

	static int sort(int[] arr, int start, int end, int numOfSwaps){

		// return if at the end
		if(start >= end)
			return numOfSwaps;

		int midpoint = (start+end)/2;

		// split array at midpoint
		numOfSwaps = sort(arr, start, midpoint, numOfSwaps);
		numOfSwaps = sort(arr, midpoint+1, end, numOfSwaps);
		// sort and merge arrays       
		numOfSwaps = merge(arr, start, midpoint, end, numOfSwaps);

		return numOfSwaps;

	}

	static int merge(int[] arr, int start, int mid, int end, int numOfSwaps){

		System.out.println("start numOfSwaps: "+numOfSwaps);
		// get size of arrays
		int leftArrayLength = (mid-start)+1;
		int rightArrayLength = (end-mid);

		// create right and left arrays
		int[] leftArray = new int[leftArrayLength];
		int[] rightArray = new int[rightArrayLength];

		// populate the left and right arrays
		for(int i=0; i<leftArrayLength; i++){
			leftArray[i] = arr[start+i];
		}

		for(int i=0; i<rightArrayLength; i++){
			rightArray[i] = arr[mid+i+1];
		}

		/* merge arrays */

		// create indexes
		int leftArrayIndex = 0;
		int rightArrayIndex = 0;
		int arrIndex = start;

		// loop until one of the arrays are full
		while( leftArrayIndex<leftArrayLength && rightArrayIndex<rightArrayLength ){

			// if the current left array element
			// is less than the current right array element
			// add it to the main array
			// otherwise do the same for the right array
			System.out.println(leftArray[leftArrayIndex] +" : "+rightArray[rightArrayIndex]);
			if(leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]){
				arr[arrIndex] = leftArray[leftArrayIndex];
				leftArrayIndex++;
				//numOfSwaps++;
			}else{
				arr[arrIndex] = rightArray[rightArrayIndex];
				rightArrayIndex++;

				// increment the swap counter
				// all elements after leftArray[leftArrayIndex] are smaller than rightArray[rightArrayIndex]
				// therefore we need to count the number of elements to be swapped 
				numOfSwaps+=leftArrayLength-leftArrayIndex;

				System.out.println("numOfSwaps++");
			}
			arrIndex++;

		}

		// add any remaining elements to the array
		while( leftArrayIndex < leftArrayLength ){
			arr[arrIndex] = leftArray[leftArrayIndex];
			leftArrayIndex++;
			arrIndex++;
		}

		while( rightArrayIndex < rightArrayLength ){
			arr[arrIndex] = rightArray[rightArrayIndex];
			rightArrayIndex++;
			arrIndex++;
			//numOfSwaps++;
		}

		System.out.println("end numOfSwaps: "+numOfSwaps);
		return numOfSwaps;

	}	
	
}
