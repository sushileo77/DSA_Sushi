/*
	LC : 201 
	BitWise AND of Numbers Range
	
	Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.
	
	Space Complexity : O(1)
	Time Complexity  : O(1)  ..( Number of Digits)
	
	Brian Kernighan's Algo
	Idea : For a given range [m,n] (i.e. m < n), we could iteratively apply trick on number n to turn off it's rightmost bit of one until it becomes <= beginning  of the range(m). Finally we do AND operation between n' and m and obtain the final result.



*/

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while(left < right)
        {
            right = right & (right -1); // The right most bit of one in the original number would be turned off (from one to zero)
        }
        
        return right & left;
    }
}