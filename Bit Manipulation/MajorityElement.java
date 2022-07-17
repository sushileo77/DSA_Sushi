/*
	LC : 169
	Majority Elements

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than [n / 2] times. You may assume that the majority element always exists in the array.

 Time Complexity : O(n)
 Space Complexity  : O(1)
 
 Logic : Boyer-Moore Voting Algo
*/

class Solution { 
	public int majorityElement(int[] nums) {
		int count = 0;
		Integer candidate = null;
		
		for(int num : nums) {
			if(count == 0)
				candidate = num;
				
			count+=(num == candidate)? 1:-1;
		}
		
		return candidate;
	}

}