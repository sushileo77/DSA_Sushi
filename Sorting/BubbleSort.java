##Bubble Sort
class Solution {
    public int[] sortArray(int[] nums) {
        int i,j,temp;
        boolean swapped;
        int n = nums.length;
        
        
        for(i =0; i < n-1; i++){
            swapped = false;
            for(j = 0; j < n-i-1; j++) {
                if(nums[j] > nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    swapped = true;
                }
            }
            
            if(swapped == false)
                break;
        }
        
        return nums;
    }
}