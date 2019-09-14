package algo.recursive;

public class App {

	public static void main(String[] args) {

		int[] intArray = {8,12,4,2,71}; 
		
		System.out.println(recursiveLinearSearch(intArray, 0, 5));

		
		int[] sortedIntArray = {1,2,3,4,5,6,7,8,9,10}; 
		System.out.println(recursiveBinarySearch(sortedIntArray, 0, sortedIntArray.length-1, 7));
	}
	
	/**
	 * recursively search for the position of element x in array a fron left to right
	 * 
	 * @param a - array to search for element in
	 * @param i - current increment
	 * @param x - element to be found
	 * @return position of x in a
	 */
	private static int recursiveLinearSearch(int[] a, int i, int x) {
		
		// x was not found in the array
		if(i > a.length-1) {
			return -1;
		}
		// base case
		else if(a[i] == x) {
			return i;
		} 
		else {
			return recursiveLinearSearch(a, i+1, x);
		}
	}
	
	/**
	 * recursively search for the position of element x in array a via binary search
	 * array must be sorted
	 * 
	 * @param a - the sorted array to search for element in
	 * @param p - smallest possible index
	 * @param r - biggest possible index
	 * @param x - element to be found
	 * @return position of x in a
	 */
	private static int recursiveBinarySearch(int[] a, int p, int r, int x) {
		
		if (p > r) {
			return -1;
		}
		else {
			// find the midpoint of the array
			int q = (p+r)/2;
			
			if(a[q] == x) {
				return q;
			}
			else if(a[q] > x){
				return recursiveBinarySearch(a, p, q-1, x);
			}else {
				return recursiveBinarySearch(a, q+1, r, x);
			}
		}
		
		
	}

}
