package algo.insertionsort;

public class App {

	public static void main(String[] args) {

		int[] myArray = insertionSort(new int[] {9, 8, 99, 110, 8, 87, 637, 8, 3, 13, 87, 12, 99});

		for(int value: myArray) {
			System.out.println(value);
		}

	}
	
	/***
	 * 
	 * Sort array one item at a time
	 * 
	 * @param a
	 * @return
	 */
	/*private static int[] insertionSort(int[] a) {
		
		int temp = 0;
		
		for(int i=1; i<a.length; i++) {
			
			// loop backwards until we find an element smaller than the current one
			for(int j=i-1; j>=0; j--) {
				
				// if the element to be sorted is smaller than current element swap them   
				if(a[j+1] < a[j]) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}else {
					break;
				}
				
			}
			
		}
		
		return a;
	}*/
	
	// solution for video
	// much better!!!
	private static int[] insertionSort(int[] a) {

		for(int i=1; i<a.length; i++) {
			
			// element to be sorted
			int element = a[i]; 
			// index of the last value in the sorted section of the array
			int j = i-1;
			
			// while the index is greater than 0 (still in the array)
			// while the element at the current index is greater the the element
			while(j>=0 && a[j]>element) {
				
				// swap the elements at the current and next index
				a[j+1] = a[j];
				j--;
				
			}
			
			// set the element to the next index
			a[j+1] = element;
			
		}
		
		return a;
	}
	
	

}
