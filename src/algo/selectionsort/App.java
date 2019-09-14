package algo.selectionsort;

public class App {

	public static void main(String[] args) {

		int[] myArray = selectionSort(new int[] {9, 8, 3, 13, 87, 12, 99});

		for(int value: myArray) {
			System.out.println(value);
		}
	}

	/**
	 * sort array from smallest to biggest 
	 * loop through array elements and place the smallest element at the start
	 * continue until all elements have been checked  
	 * 
	 * @param a
	 * @return
	 */
	public static int[] selectionSort(int a[]) {
		
		int min=0;
		int temp=0;
		
		for(int i=0; i<a.length; i++) {
			
			min = i;
			
			// check the remaining array elements 
			for(int j = i+1; j<a.length; j++) {
				
				// if the current element is less than than the min element
				if(a[j] < a[min]) {
					// set the current element to the smallest (min)
					min = j;
				}
				
			}
			
			// swap the min and max elements 
			temp = a[min];
			a[min] = a[i];
			// bring the smaller element forward in the array
			a[i] = temp; 
			
		}
		
		return a;
		
	}
}
