// https://leetcode.com/problems/stone-game

class Solution {
    int getMax(int st, int end, int[] piles, int[][] dp){
        if(st==end)
            return piles[st];

        if(dp[st][end]!=0)
            return dp[st][end];
        
        int takeFirst = piles[st]-getMax(st+1, end, piles, dp);

        int takeLast = piles[end]-getMax(st, end-1, piles, dp);

        return dp[st][end] = Math.max(takeFirst, takeLast);
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        // for(int[] i: dp)
        //     Arrays.fill(i, -1);
        
        for(int i=0;i<n;i++)
            dp[i][i] = piles[i];
        
        return getMax(0, n-1, piles, dp)>0;
    }
}