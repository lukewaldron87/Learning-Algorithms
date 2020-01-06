package algo.quicksort;

import java.util.Arrays;

public class PracticeApp2 {

	public static void main(String[] args) {
		
		
		int[] inputArray = {12,81,74,43,1098,0,8,92,17,754,912,0,6,4};
		quickSort(inputArray, 0, inputArray.length-1);
		
		System.out.println(Arrays.toString(inputArray));

	}
	
	private static void quickSort(int[] inputArray, int min, int max) {
		
		if(min < max) {
			
			int pivotIndex = pivot(inputArray, min, max);	
			
			quickSort(inputArray, min, pivotIndex-1);
			quickSort(inputArray, pivotIndex+1, max);
			
		}
		
	}
	
	private static int pivot(int[] inputArray, int min, int max) {
		
		int pivot = inputArray[max];
		
		int leftWallIndex = min;
		
		for(int i=min; i<max; i++) {
			
			if(inputArray[i] < pivot) {
				
				int temp = inputArray[i];
				inputArray[i] = inputArray[leftWallIndex];
				inputArray[leftWallIndex] = temp;
				leftWallIndex++;
			}
			
		}
		
		// swap pivot with left wall
		inputArray[max] = inputArray[leftWallIndex];
		inputArray[leftWallIndex] = pivot;
		
		
		return leftWallIndex;
	}
}
