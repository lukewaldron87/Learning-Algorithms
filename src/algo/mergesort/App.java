package algo.mergesort;

public class App {

	public static void main(String[] args) {

		int[] inputArray = {9,7,3,1,6,3,2,6,10,9,21,3,0};
		
		PracticeMergeSort sorter = new PracticeMergeSort();
		
		sorter.sort(inputArray);
		
		for(int element: inputArray) {
			System.out.print(element+" ");
		}
		System.out.println();

		
		int[] inputArray2 = {5,6,1,99, 65,85,12,2,8,3};
		
		sorter.sort(inputArray2);
		
		for(int element: inputArray2) {
			System.out.print(element+" ");
		}
		System.out.println();
	}

}