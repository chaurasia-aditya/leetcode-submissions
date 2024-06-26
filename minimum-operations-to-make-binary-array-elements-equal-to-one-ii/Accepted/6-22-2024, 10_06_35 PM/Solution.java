// https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-ii

class Solution {
    public int minOperations(int[] nums) {
        int flips = 0;
        int n = nums.length;

        for(int i=0;i<n;i++){
            if(((flips&1) == 0 && nums[i] == 0)||((flips&1) == 1 && nums[i]==1)){
                flips++;
            }
        }

        return flips;
    }
}