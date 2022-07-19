/*

215. Kth Largest Element in an Array
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

You must solve it in O(n) time complexity.

O(N) : So you QuickSelect
*/

import java.util.Random;

class Solution {
    int[] nums;
    
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int size  = nums.length;
        
        // Kth Largest is (N-k)th smallest
        return quickselect(0, size - 1, size-k);
    }
    
    public int quickselect(int left, int right, int k_smallest) {
        /*
        
            Returns Kth Smallest Element of List within Left .. Right.
        
        */
        
        if(left == right) // If the list contains only one element, return that element
            return this.nums[left];
        
        // select a random pivot_index
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);
        
        pivot_index = partition(left, right, pivot_index);
        
        // the pivot is on (N-k) th smallest position
        if(k_smallest == pivot_index)
            return this.nums[k_smallest];
        // go left side
        else if (k_smallest < pivot_index)
            return quickselect(left, pivot_index-1,k_smallest);
        else
            return quickselect(pivot_index+1, right, k_smallest);
    }
    
    public int partition(int left, int right, int pivot_index) {
        int pivot = this.nums[pivot_index];
        
        // 1. move pivot to end
        swap(pivot_index, right);
        
        int store_index = left;
        
        // 2. Move all smaller elements to the Left
        for(int i = left; i <= right; i++){
            if(this.nums[i] < pivot) {
                swap(store_index, i);
                store_index++;
            }
        }
        
        //3. move pivot to it;s final place
        swap(store_index, right);
        return store_index;
    }
    
    public void swap(int a, int b) {
        int tmp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = tmp;
    }
}