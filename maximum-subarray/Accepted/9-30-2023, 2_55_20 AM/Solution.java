// https://leetcode.com/problems/maximum-subarray

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int max = nums[0];
        int cur = nums[0];
        for(int i=1;i<nums.length;i++){
            cur = Math.max(cur+nums[i], nums[i]);
            max = Math.max(max, cur);
        }
        return max;
    }
}