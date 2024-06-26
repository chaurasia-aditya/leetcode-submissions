// https://leetcode.com/problems/coin-change

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;

        int[] dp = new int[amount+1];
        Arrays.fill(dp, (int)1e9);
        dp[0] = 0;


        for (int coin:coins) {
            for (int i=coin;i<=amount;i++) {
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }

        return (dp[amount]>=1e9?-1:dp[amount]);
    }
}