// https://leetcode.com/problems/stone-game

class Solution {
    int getMax(int st, int end, int n, int[] piles, int[][] dp){
        if(st>end)
            return 0;

        if(dp[st][end]!=-1)
            return dp[st][end];
        
        int takeFirst = piles[st]+Math.min(getMax(st+2, end, n, piles, dp), getMax(st+1, end-1, n, piles, dp));

        int takeLast = piles[end]+Math.min(getMax(st, end-2, n, piles, dp), getMax(st+1, end-1, n, piles, dp));

        dp[st][end] = Math.max(takeFirst, takeLast);
        return dp[st][end];
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int total = 0;

        for(int i: piles)
            total+=i;

        int[][] dp = new int[n][n];
        for(int[] i: dp)
            Arrays.fill(i, -1);
        
        for(int i=0;i<n;i++)
            dp[i][i] = piles[i];
        
        int max = getMax(0, n-1, n, piles, dp);

        return max>total-max;
    }
}