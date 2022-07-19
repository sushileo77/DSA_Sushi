/*

	LC : 75 Sort Colors

*/

class Solution {
    public void sortColors(int[] nums) {
        int curr = 0;
        int p1 = 0;
        int p2 = nums.length - 1;
        int tmp;
        
        while(curr <= p2) {
            if(nums[curr] == 0) {
                tmp = nums[p1];
                nums[p1] = nums[curr];
                nums[curr] = tmp;
                curr++;
                p1++;
            }
            else if(nums[curr] == 2){
                tmp = nums[p2];
                nums[p2] = nums[curr];
                nums[curr] = tmp;
                p2--;
            }
            else {
                curr++;
            }
        }
    }
}