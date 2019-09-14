package algo.insertionsort;

public class NewTry {

	public static void main(String[] args) {

		int[] myArray = insertionSort(new int[] {9, 8, 99, 110, 8, 87, 637, 8, 3, 13, 87, 12, 99});

		for(int value: myArray) {
			System.out.println(value);
		}

	}
	
	private static int[] insertionSort(int[] unsortedArray) {
		
		int temp;
		
		for(int i=1; i<unsortedArray.length; i++) {
			
			for(int j=i; j>=1; j--) {
				
				if(unsortedArray[j] < unsortedArray[j-1]) {
					temp = unsortedArray[j];
					unsortedArray[j] = unsortedArray[j-1];
					unsortedArray[j-1] = temp;
				}
				
			}
			
		}
		
		return unsortedArray;
		
	}
}
