# Counting Sort

class CountingSort {
	void countSort(int array[], int size) {
		int[] output = new int[size + 1];
		
		// Find Largest element of array
		
		int max = array[0];
		
		for(int i=1; i<size; i++) {
			if(array[i] > max)
				max = array[i];
			
		}
		
		int count[] = new int[max+1];
		
		//Initialize count array with all zeroes
		
		for(int i=0; i< max; i++)
			count[i] = 0;
		
		// Store cout of each element
		
		for(int i =0; i<=max;i++){
			count[array[i]]++;
		}
		
		// Store the cumulative count of each array
		
		for(int i=1; i <=max; i++) {
			count[i]+=count[i-1];
			
		}
		
		 // Find the index of each element of the original array in count array, and
		// place the elements in output array
		for(int i = size-1; i>=0; i--){
			output[count[array[i]] - 1] = array[i];
			count[array[i]]--;
			
		}
	
		// Copy the sorted elements into original array
	 
		for(int i=0; i< size; i++) {
			array[i] = output[i];
		}
	}

}