// https://leetcode.com/problems/stone-game

class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)
            dp[i][i] = piles[i];
        
        for(int d = 1;d<n;d++){
            for(int i=0;i<n-d;i++){
                dp[i][i+d] = Math.max(piles[i+d]-dp[i][i+d-1], piles[i]-dp[i+1][i+d]);
            }
        }

        return dp[0][n-1]>0;
    }
}