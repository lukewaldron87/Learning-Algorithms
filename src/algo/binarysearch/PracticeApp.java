package algo.binarysearch;

import java.util.Stack;

public class PracticeApp {

	public static void main(String[] args) {

		int[] inputArray = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

		System.out.println("index of search value: "+binarySearch(inputArray, 0, inputArray.length-1, 4));
		
	}
	
	private static int binarySearch(int[] inputArray, int start, int end, int searchValue) {
		
		// get the midpoint
		int midpoint = (start+end)/2;
		int searchIndex;
		
		// if midpoint is less than the searchValue
		// partition the array to the right of the midpoint
		// otherwise partition the array to the left
		if(inputArray[midpoint] < searchValue) {
			
			return binarySearch(inputArray, midpoint+1, end, searchValue);
			
		}else if(inputArray[midpoint] > searchValue) {
			
			return binarySearch(inputArray, start, midpoint-1, searchValue);
			
		}else {
			// if the midpoint is the same as the searchvalue return it
			return midpoint;
		}
	
	}

	/**
	 * 
	 * 1.) Counting sort
	 * 
	 * 2.) A Queue
	 * 
	 * 3.) Pay attention to the even case.
	 * 
	 * 4.) Integer division is a blessing and a curse, be careful.
	 * 
	 * @param expenditure
	 * @param d
	 * @return
	 */
	static int activityNotifications(int[] expenditure, int d) {

		int sum = 0;
		int numOfNotifications = 0;
		int limit;

		for(int i=0; i<expenditure.length; i++) {

			// if the correct number of days have been passed 
			if( i >= d ) {
				 
				limit = ((sum/d)*2);
				 
				System.out.println("d: "+d);
				System.out.println("i: "+i);
				System.out.println("sum: "+sum);
				System.out.println("median: "+sum/5);
				System.out.println("limit: "+limit);
				System.out.println("expenditure["+i+"]: "+expenditure[i]);

				// compare the current day's expenditure to the median x2
				if( expenditure[i] >= ((sum/5)*2) ) {
					numOfNotifications++;
					System.out.println("numOfNotifications: "+numOfNotifications);
				}

				// remove the first day;
				sum -= expenditure[i-d];
			}

			sum += expenditure[i];

		}

		return numOfNotifications;

    }

}
