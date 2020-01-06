package algo.binarysearch;

import java.util.Stack;

public class PracticeApp {

	public static void main(String[] args) {

		int[] inputArray = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

		System.out.println("index of search value shoud be 4 and is: "+binarySearch(inputArray, 0, inputArray.length-1, 4));
		System.out.println("index of search value shoud be 12 and is: "+binarySearch(inputArray, 0, inputArray.length-1, 12));
		System.out.println("index of search value shoud be 15 and is: "+binarySearch(inputArray, 0, inputArray.length-1, 15));
		System.out.println("index of search value shoud be 5 and is: "+binarySearch(inputArray, 0, inputArray.length-1, 5));
		System.out.println("index of search value shoud be 0 and is: "+binarySearch(inputArray, 0, inputArray.length-1, 0));
		
	}
	
	/**
	 * 
	 * find an element in a sorted array
	 * 
	 * return the index of x
	 * 
	 * 
	 * 
	 * @param inputArray
	 * @param min
	 * @param max
	 * @param x
	 * @return
	 */
	private static int binarySearch(int[] inputArray, int min, int max, int x) {
		
		// calculate the midpoint
		int mid = (max+min)/2;
		
		// check if the element at the midpoint is
		// less then, greater than or equal to the midpoint element
		// if not equal recursively call the method and set the min and max to the appropriate side of the midpoint
		if(inputArray[mid] < x) {
			// if less than check to the right of the midpoint
			return binarySearch(inputArray, mid+1, max, x);
		}else if(inputArray[mid] > x) {
			// if greater than check to the left of the midpoint 
			return binarySearch(inputArray, min, mid-1, x);
		}else {
			// otherwise return the midpoint index
			return mid;
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
