/*
	LC : #137
	Single Number II
	
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.		

You must implement a solution with a linear runtime complexity and use only constant extra space.

 
*/

/*
	Method : I
	
	Concept : 
	First of all, consider the (set^val) as one of the following:
		1. adding "val" to the "set" if "val" is not in the "set" => A^0 = A
		2. removing "val" from the "set" if "val" is already in the "set" => A^A = 0

		Assume "ones" and "twos" to be sets that are keeping track of which numbers have appeared once and twice respectively;

		"(ones ^ A[i]) & ~twos" basically means perform the above mentioned operation if and only if A[i] is not present in the set "twos". So to write it in layman:

		IF the set "ones" does not have A[i]
			Add A[i] to the set "ones" if and only if its not there in set "twos"
		ELSE
			Remove it from the set "ones"
		So, effectively anything that appears for the first time will be in the set. Anything that appears a second time will be removed. We'll see what happens when an element appears a third time (thats handled by the set "twos").

	After this, we immediately update set "twos" as well with similar logic:
		"(twos^ A[i]) & ~ones" basically means:

   IF the set "twos" does not have A[i]
       Add A[i] to the set "twos" if and only if its not there in set "ones"
   ELSE
       Remove it from the set "twos"
	So, effectively, any number that appears a first time will be in set "ones" so it will not be added to "twos". Any number appearing a second time would have been removed from set "ones" in the previous step and will now be added to set "twos". Lastly, any number appearing a third time will simply be removed from the set "twos" and will no longer exist in either set.

	Finally, once we are done iterating over the entire list, set "twos" would be empty and set "ones" will contain the only number that appears once.
	
	Concise :
	
	First time number appear -> save it in "ones"

	Second time -> clear "ones" but save it in "twos" for later check
	
	Third time -> try to save in "ones" but value saved in "twos" clear it.

	Time Complexity  : O(n)
	Space Complexity : O(1)
*/

public int singleNumber(int[] A){
	int ones = 0,twos =0;
	
	for(int i =0;i < A.length; i++){
		ones = (ones ^ A[i]) & ~twos;
		twos = (twos ^ A[i]) & ~ones;
	}
	return ones;
}


/*

	Method : II
	Counting Set Bits
	
	Technique :-
	
	Time  Complexity  : O(32N)
	Space Complexity  : O(1)
	
	- Check for all 32 Bits
	- Use Shift to find if current bit is Set

	Think about the number in 32 bits and just count how many 1s are there in each bit.
	Sum %=3 will clear it once it reaches 3
	After running for all numbers for each bit, if we have a 1 , then that 1 belongs to single number. We can simply move it back to it's sport by doing res |= mask

*/

class Solution {
    private static final int INT_SIZE = 32;
    
    public int singleNumber(int[] nums) {
        int result = 0;
        
        for(int j =0; j < INT_SIZE; j++) {
            int mask = (1 << j);
            int sum  = 0;
            
            for(int numsItr = 0; numsItr < nums.length ; numsItr++){
                if((nums[numsItr] & mask) != 0) {
                    sum+=1;
                }
            }
            
            if((sum % 3) == 1) { // at this bit position, single element is present. Add it's weightage to the answer
                result |= mask; // Use Mask to set Bit (1) / Weightage at that position. Weightage decided by the shift operator
            }
        }
        
        return result;
    }
}