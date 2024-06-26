// https://leetcode.com/problems/coin-change

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;

        int[] dp = new int[amount+1];
        Arrays.fill(dp, (int)1e9);
        dp[0] = 0;

        for(int i = 1; i<=amount;i++){
            int min= Integer.MAX_VALUE;
            for(int j:coins){
                if(j<=i && min>dp[i-j]+1){
                    min = dp[i-j]+1;
                }
            }
            dp[i] = Math.min(min, dp[i]);
        }

        return (dp[amount]>=1e9?-1:dp[amount]);
    }
}