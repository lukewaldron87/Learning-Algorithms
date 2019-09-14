package algo.linearsearch;

public class App {

	public static void main(String[] args) {

		int[] intArray = {1,2,3,4,5}; 
		
		System.out.println(linearSearch(intArray, 2));

	}
	
	// O(n) - scales linearly 
	private static int linearSearch(int[] a, int x) {
		
		int answer = -1;
		
		// loop through array until value x is found
		for(int i=0; i<a.length; i++) {
			
			if(a[i] == x) {
				return i;
			}
			
		}
		
		return answer;
	}

}
