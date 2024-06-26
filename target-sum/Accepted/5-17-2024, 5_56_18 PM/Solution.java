// https://leetcode.com/problems/target-sum

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;

        for(int n:nums){
            total+=n;
        }

        if(total<target || (total-target)%2 != 0)
            return 0;
        
        int n = (total - target) / 2;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for (int v : nums) {
            for (int j = n; j >= v; --j) {
                dp[j] += dp[j - v];
            }
        }
        return dp[n];
    }
}