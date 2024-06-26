// https://leetcode.com/problems/coin-change-ii

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp =new int[amount+1];
        dp[0] = 1;
        for (int num : coins) {
            for (int i = 0; i <= amount-num; i++) {
                dp[i+num] += dp[i];
            }
        }
        return dp[amount];
    }
}