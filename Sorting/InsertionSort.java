/*

	Insertion Sort

	Insertion Sort Algorithm 
		To sort an array of size N in ascending order: 

		Iterate from arr[1] to arr[N] over the array. 
		Compare the current element (key) to its predecessor. 
		If the key element is smaller than its predecessor, compare it to the elements before. Move the greater elements one position up to make space for the swapped element.

*/


class InsertionSort {

	void sort(int[] arr) {
		int n = arr.length;
		
		for(int i = 1; i < n; i++) {
		
			int key = arr[i];
			int j = i-1;
			
			/*
				Move elements of arr[0 .. i-1] , that are greater than key, to one position ahead of their current position
			
			*/
			
			while(j >=0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			
			}
			
			arr[j+1] = key;
		}
	
	
	}
	
	// Driver Method 
	
	public static void main(String args[]) {
		int arr[] = {12,11,13,5,6};
		
		InsertionSort ob = new InsertionSort();
		ob.sort(arr);
	}

}
