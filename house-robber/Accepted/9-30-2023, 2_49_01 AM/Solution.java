// https://leetcode.com/problems/house-robber

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int[] steal = new int[nums.length];
        steal[0] = nums[0];
        steal[1] = nums[1];
        int max = Math.max(steal[0], steal[1]);
        for(int i=2;i<nums.length;i++){
            steal[i] = Math.max(steal[i-2],steal[i-1]-nums[i-1])+nums[i];
            max = Math.max(max, steal[i]);
        }
        return max;
    }
}