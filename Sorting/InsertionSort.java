# Selection Sort

class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        
        
        for(int i =0; i < n -1; i++){
            int min_index = i;    
            for(int j = i+1; j < n; j++){
                if(nums[j] < nums[min_index])
                    min_index = j;
            }
            
            int temp = nums[min_index];
            nums[min_index] = nums[i];
            nums[i] = temp;
        }
        
        return nums;
    }
}

// Driver code to test above
    public static void main(String args[])
    {
        SelectionSort ob = new SelectionSort();
        int arr[] = {64,25,12,22,11};
        ob.sort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }