// https://leetcode.com/problems/coin-change

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        dp[0] = 0;

        for(int i = 1; i<=amount;i++){
            int min= Integer.MAX_VALUE;
            for(int j:coins){
                if(j<=i && dp[i-j]!=-1 && min>dp[i-j]+1){
                    min = dp[i-j]+1;
                }
            }
            if(min == Integer.MAX_VALUE)
                dp[i] = -1;
            else
                dp[i] = min;
        }

        return dp[amount];
    }
}