package algo.binarysearch;

public class App {

	public static void main(String[] args) {

		int[] intArray = {1,2,3,4,5}; 
		
		System.out.println(binarySearch(intArray, 6));
		
		int[] intArray2 = {1,2,3,4,5,21,89,124}; 
		
		System.out.println(recursiveBinarySearch(intArray2, 0, intArray2.length-1, 21));
		
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
	
	
	
	
	/**
	 * Returns the location of a element x in array a
	 * 
	 * @param a - array to be search
	 * @param x - element to be found in array
	 * @return the location of a element x in array a or -1 if not found
	 */
	private static int binarySearch(int[] a, int x) {
		
		int p = 0;
		int r = a.length-1;
		int q = 0;
		
		
		while(p <= r) {
			
			q = (p+r)/2;
			
			if(a[q] == x) {
				return q;
			}else if(a[q] > x) {
				r = q-1;
			}else {
				p = q+1;
			}
			
		}
		
		return -1;
	}

}
