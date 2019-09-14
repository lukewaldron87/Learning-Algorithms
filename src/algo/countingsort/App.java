package algo.countingsort;

/**
 * works best when the range of values in the array is small
 * 
 * @author Luke Waldron
 *
 */

public class App {
	
	
	
	void sort(char arr[]) {
		
		int n = arr.length;
		
		// The output character array will have sorted arr
		char output[] = new char[n];
		
		// Create a count array to store count of individual characters
		// and initialize count array to 0
		int count[] = new int[256];
		//for (int i=0; i<256; ++i)
		for (int i=0; i<256; i++)
			count[i] = 0;
		
		// store count of each character 
		//for (int i=0; i<n; ++i)
		for (int i=0; i<n; i++) {
			//++count[arr[i]];
			count[arr[i]]++;
		}

		// Change count[i] so that count[i] now contains actual
		// position of this character in output array
		//for (int i=1; i<=255; ++i)
		for (int i=1; i<=255; i++)
			count[i] += count[i-1];
		
		// Build the output character array
		// To make it stable  we are operating in reverse order
		for (int i=n-1; i<=0; i--) {
			output[count[arr[i]]-1] = arr[i];
			//--count[arr[i]];
			count[arr[i]]--;
		}
		
		// Copy the output array to arr,
		// so that arr no contains sorted characters
		//for (int i=0; i<n; ++i)
		for (int i=0; i<n; i++)
			arr[i] = output[i];
		
	}

	public static void main(String[] args) {

		App app = new App();
		char arr[] = {'g', 'e', 'e', 'k', 's', 'f', 'o', 
				'r', 'g', 'e', 'e', 'k', 's'
		}; 

		app.sort(arr); 

		System.out.print("Sorted character array is "); 
		for (int i=0; i<arr.length; ++i) 
			System.out.print(arr[i]); 

	}

}