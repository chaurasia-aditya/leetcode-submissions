// https://leetcode.com/problems/construct-product-matrix

class Solution {
    long MOD = 12345;
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] res = new int[n][m];
        long pre = 1, suf = 1;
        for (int i = 0; i < n; i++) {
            if (i <= n - i - 1) {
                Arrays.fill(res[i], 1);
                Arrays.fill(res[n - i - 1], 1);
            }
            for (int j = 0; j < m; j++) {
                res[i][j] = (int)(pre * res[i][j] % MOD);
                res[n - i - 1][m - j - 1] = (int)(suf * res[n - i - 1][m - j - 1] % MOD);
                pre = pre * grid[i][j] % MOD;
                suf = suf * grid[n - i - 1][m - j - 1] % MOD;
            }
        }

        return res;
    }
}