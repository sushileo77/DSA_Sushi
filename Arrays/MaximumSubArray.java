/*

LC 53 : Maximum Subarray
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

Idea : Use Kadane's algorithms

Space Complexity : O(1)
Time Complexity  : O(N)
*/

 public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int totalMax = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            maxSoFar = Math.max(nums[i], maxSoFar + nums[i]);
            totalMax = Math.max(maxSoFar, totalMax);
        }
    
        return totalMax;
    }
    
}