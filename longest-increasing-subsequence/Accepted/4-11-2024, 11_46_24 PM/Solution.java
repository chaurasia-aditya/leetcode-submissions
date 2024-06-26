// https://leetcode.com/problems/longest-increasing-subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                dp[i] = nums[i]>nums[j]?Math.max(dp[i], dp[j]+1):dp[i];
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}