// https://leetcode.com/problems/coin-change-ii

class Solution {

    int recur(int i, int target, int[][] dp, int[] coins, int n){
        if(target == 0){
            return 1;
        }

        if(i<n){
            if(dp[i][target] == -1){
                if(coins[i]>target)
                    return 0;
                return dp[i][target] = recur(i, target-coins[i], dp, coins, n) + recur(i+1, target, dp, coins, n);
            }
            return dp[i][target];
        }

        return 0;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        Arrays.sort(coins);

        int[][] dp = new int [n][amount+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);    
        
        

        return recur(0, amount, dp, coins, n);
    }
}