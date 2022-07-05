/*
    Idea :
    we know the key to solve this problem is SUM[i, j]. So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j]. To achieve this, we just need to go through the array, calculate the current sum and save number of        all    seen PreSum to a HashMap. Time complexity O(n), Space complexity O(n).

*/


/*

Example 

First of all, the basic idea behind this code is that, whenever sums has increased by a value of k, we've found a subarray of sums=k.
I'll also explain why we need to initialise 0 in the hashmap.
Example: Let's say our elements are [1,2,1,3] and k = 3.
and our corresponding running sums = [1,3,4,7]
Now, if you notice the running sums array, from 1->4, there is increase of k and from 4->7, there is an increase of k. So, we've found 2 subarrays of sums=k.

But, if you look at the original array, there are 3 subarrays of sums==k. Now, you'll understand why 0 comes in the picture.

In the above example, 4-1=k and 7-4=k. Hence, we concluded that there are 2 subarrays.
However, if sums==k, it should've been 3-0=k. But 0 is not present in the array. To account for this case, we include the 0.
Now the modified sums array will look like [0,1,3,4,7]. Now, try to see for the increase of k.

0->3
1->4
4->7
Hence, 3 sub arrays of sums=k


0  1 2 1 3

PSum = 1 3 4 .. here when we are at 4; so presum - k i.e. (4 -3) = 1. We have seen 1 in the hashMap, so there is a sub-array between that pSum 1 and pSum4 in og array ( 2 + 1) = 3
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int result = 0;
        
        Map<Integer, Integer> preSum = new HashMap<>();
        
        preSum.put(0,1);
        
        
        for(int i =0; i < nums.length; i++) {
            sum+=nums[i];
            
            if(preSum.containsKey(sum - k)) {
                result+= preSum.get(sum - k);
            }
            
            preSum.put(sum , preSum.getOrDefault(sum ,0 )+1);
        }
        
        return result;
    }
}