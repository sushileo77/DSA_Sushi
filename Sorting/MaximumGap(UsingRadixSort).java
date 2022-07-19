class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        radixSort(nums,n);
        
        int maxGap = 0;
        
        for(int i =0; i < nums.length - 1; i++){
            maxGap = Math.max(maxGap, nums[i+1] - nums[i]);
        }
        
        return maxGap;
    }
    
    public void radixSort(int[] nums, int n) {
        int m = getMax(nums, n);  //Find the largest element in the array, i.e. mx.
                                 //Let X be the number of digits in max.
                                 //X is calculated because we have to go through all the significant places of all elements.
        
        for(int exp = 1; m/exp > 0 ; exp*=10) { // Apply counting sort to sort elements based on place value.
            countSort(nums, n , exp);
        }
    }
    
    // Function to get the largest element from an array
    public int getMax(int[] nums, int n) {
        int mx = nums[0];
        
        for(int i =1; i < n ;i++){
            if(nums[i] > mx)
                mx = nums[i];
        }
        
        return mx;
    }
    
    public void countSort(int[] nums, int n , int exp) {
        int[] output = new int[n];
        int i;
        int[] count  = new int[10];
        
        Arrays.fill(count,0);
        
         // Calculate count of elements
        for(i =0; i < n; i++)
            count[(nums[i] / exp) %10] ++;
        
        // Calculate cumulative count
        for(i =1; i < 10; i++)
            count[i] += count[i-1];
        
        // Place the elements in sorted order
        for(i =  n-1; i>=0; i--) {
            output[count[(nums[i]/exp) % 10] - 1] = nums[i];
            count[(nums[i]/exp) %10]--;
        }
        
        for(i = 0; i < n ; i++){
            nums[i] = output[i];
        }
        
    }
	
	 // Driver code
  public static void main(String args[]) {
    int[] data = { 121, 432, 564, 23, 1, 45, 788 };
    int size = data.length;
    RadixSort rs = new RadixSort();
    rs.radixSort(data, size);
    System.out.println("Sorted Array in Ascending Order: ");
    System.out.println(Arrays.toString(data));
  }
}