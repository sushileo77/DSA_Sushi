/*
	QuickSort

*/

static void swap(int [] arr, int i, int j) {
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}

static int partition(int [] arr, int low, int high)
{
	int i = low-1;
	
	for(int j = 0; j <= high-1; j++) {
	
		if(arr[j] < pivot){
			// increment index of smaller element
			
			i++;
			swap(arr, i,j);
		
		}
	
	}
	
	swap(arr, i+1, high);
	return(i+1);


}

public void quickSort(int [] arr, int low, int high)
{
	if(low < high) 
	{
		// pi is the partition index 
		
		int pi = partition(arr, low, high);
		quickSort(arr, low, pi-1);
		quickSort(arr, pi+1, high);
	
	}


}

public static void main(String[] args) 
{
	int[] arr = {10,7,8,9,1,5};
	int  n = arr.length;
	quickSort(arr, 0, n-1);

}
