#Bucket Sort
public void bucketSort(int[] arr, int n) {
	if(n < =0)
		return;
	
	ArrayList<Integer> bucket = new ArrayList<>();
	
	// Create Empty Buckets
	
	for(int i =0; i < n; i++)
		bucket[i] = new ArrayList<>();
	
	// Add Elements to Buckets
	
	for(int i =0; i < n; i++)
		bucket[i].add(arr[i]);
	
	for(int i =0; i< n;i++)
		Collections.sort(bucket[i]);
	
	// Get the sorted Array
	int index = 0;
	for(int i =0; i < n; i++) {
		for(int j =0; size = buck[i].size(); j < size; j++) {
			arr[index++] = bucket[i].get(i);
		}
		
	}
	
	
}