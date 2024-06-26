// https://leetcode.com/problems/house-robber

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int max = Math.max(nums[0], nums[1]);

        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-2], dp[i-1]-nums[i-1])+nums[i];
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}