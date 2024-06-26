// https://leetcode.com/problems/construct-product-matrix

class Solution {
    final long MOD = 12345;
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] res = new int[n][m];
        long pre = 1, suf = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = (int)(pre);
                pre = pre * grid[i][j] % MOD;
            }
        }

        for (int i = n-1; i >=0; i--) {
            for (int j = m-1; j >= 0; j--) {
                res[i][j] = (int)(suf * res[i][j] % MOD);
                suf = suf * grid[i][j] % MOD;
            }
        }

        return res;
    }
}