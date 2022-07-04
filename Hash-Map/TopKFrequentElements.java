
/*

	Idea :
		Top Kth Frequent Elements is same as : (N-k)th less frequent elements or (N-k)th smallest elements
		
		Sort Unique array of HashMap keys to find the position of the pivot
		This pivot should be at the position (N-k) in the sorted array
		So, the elements to the right of it are most frequent and left are less frequent
		
		<1> Create HashMap
		<2> Make unique Array of Keys
		<3> Use QuickSelect Algo to get the pivot element 
		<4> Return the array range from (n-k, to n) - Most frequent
		<5> QuickSelect
				- Select a random pivot
				- Use partition algo to adjust pivot position
				- Keep pivot index at end of the list
				- Get the frequency for that keySet
				- Set Store Index to left 
				- Swap less frequency elements with Store Index and increment it by 1
				- Or else don't do anything
				- In the end, swap the Store Index with right and return
				
		<6> If the pivot index matches k_smallest ; return
		<7> Otherwise modify the range accordingly
		


*/

class Solution {
    int[] unique;
    Map<Integer, Integer> count;
    
    private void quickselect(int left, int right, int k_smallest) {
        
          /*
        
            Sort a list withing left .. right till kth less frequent 
            element takes its place
        
        */
        
        if(left == right)
            return;
        
        // select random pivot index
        Random randNum = new Random();
        int pivot_index = left + randNum.nextInt(right - left);
        
        // find perfect pivot position in a sorted list
        
        pivot_index = partition(left, right, pivot_index);
        
        if(k_smallest  == pivot_index)
            return;
        else if(k_smallest < pivot_index)
            // go left
            quickselect(left, pivot_index-1, k_smallest);
        else
            quickselect(pivot_index+1, right, k_smallest);
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        count = new HashMap<>();
        
        for(int num : nums){
            count.put(num, count.getOrDefault(num,0) + 1);
        }
        
        int n = count.size();
        
        unique = new int[n];
        
        int i =0;
        
        for(int t : count.keySet()) {
            unique[i] = t;
            i++;
        }
        
        // kth top frequent element is (n - k)th less frequent.
        // Do a partial sort : from less frequent to most frequent till (n-k)th less frequent element takes its place in sorted array
        // All elements on the left are less frequent
        // All elements on the right are more frequent
        
        quickselect(0 , n-1, n-k);
        
        return Arrays.copyOfRange(unique, n-k, n);
        
    }
    
  
    
    
    private int partition(int left, int right, int pivot_index) {
        int pivot_freq = count.get(unique[pivot_index]);
        
        int sIndex = left;
        // move pivot to end
        
        swap(pivot_index, right);
    
        // 2 move all less frequent elements to left
        
        for(int i=left; i<=right; i++) {
            if(count.get(unique[i]) < pivot_freq){
                swap(sIndex, i);
                sIndex++;
            }
        }
        
        // 3 Move Pivot to final place
        
        swap(sIndex, right);
        return sIndex;
        
    
    }
    
    private void swap(int a, int b) {
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }
}