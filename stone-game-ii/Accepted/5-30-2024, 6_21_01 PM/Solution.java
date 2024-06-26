// https://leetcode.com/problems/stone-game-ii

class Solution {

    // int recur(int pos, int n, int[] piles, int m, int curA, int curB, boolean isAlice){
    //     if(pos >= n){
    //         return isAlice ? curB : curA;
    //     }
            
    //     int newCur = isAlice ? curA : curB;

    //     int max = 0;
    //     for(int i=pos; i<Math.min(n, pos+2*m);i++){
    //         newCur+=piles[pos];
    //         if(isAlice)
    //             max = Math.max(max, recur(i+1, n, piles, Math.max(m, i-pos+1), newCur, curB, false));
    //         else
    //             max = Math.max(max, recur(i+1, n, piles, Math.max(m, i-pos+1), curA, newCur, true));
    //     }

    //     return max;
    // }

    private int recur(int pos, int m, int[] piles, boolean isAlice, int[][][] memo) {
        int n = piles.length;
        if (pos >= n) {
            return 0;
        }
        
        if (memo[pos][m][isAlice ? 0 : 1] != -1) {
            return memo[pos][m][isAlice ? 0 : 1];
        }
        
        int maxStones = isAlice ? 0 : Integer.MAX_VALUE;
        int sum = 0;
        
        for (int x = 1; x <= 2 * m && pos + x - 1 < n; x++) {
            sum += piles[pos + x - 1];
            
            if (isAlice) {
                maxStones = Math.max(maxStones, sum + recur(pos + x, Math.max(m, x), piles, false, memo));
            } else {
                maxStones = Math.min(maxStones, recur(pos + x, Math.max(m, x), piles, true, memo));
            }
        }
        
        memo[pos][m][isAlice ? 0 : 1] = maxStones;
        return maxStones;
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;

        int[][][] memo = new int[n][n+1][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j][0] = memo[i][j][1] = -1;
            }
        }
        
        return recur(0, 1, piles, true, memo);
    }
}