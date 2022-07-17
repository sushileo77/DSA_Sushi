/*
	LC : #136
	Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

	You must implement a solution with a linear runtime complexity and use only constant extra space.
*/

/*
	Concept : XOR all bits together. Duplicated Elements will cancel out and only non-repeated element will remain. Return the output of all Xored
	Time Complexity  : O(n)
	Space Complexity : O(1)
*/

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        for(int num : nums){
            result^=num;
        }
        
        return result;
    }
}