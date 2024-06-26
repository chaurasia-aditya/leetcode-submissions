// https://leetcode.com/problems/maximum-difference-score-in-a-grid

class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
//         long[][] dp = new long[m][n];
        
//         dp[m-1][n-1] = grid.get(m-1).get(n-1);
        
//         long max = Long.MIN_VALUE;
        
//         for (int i = m - 1; i >= 0; i--) {
//             for (int j = n - 1; j >= 0; j--) {
//                 if (i == m - 1 && j == n - 1) {
//                     continue;
//                 }

//                 long downScore = Integer.MIN_VALUE;
//                 long rightScore = Integer.MIN_VALUE;

//                 if (i + 1 < m) {
//                     downScore = dp[i + 1][j] - grid.get(i+1).get(j);
//                 }

//                 if (j + 1 < n) {
//                     rightScore = dp[i][j + 1] + grid.get(i).get(j+1);
//                 }

//                 dp[i][j] = Math.max(downScore, rightScore);
                
//                 max = dp[i][j]>max?dp[i][j]:max;
//             }
//         }
        
        int[][] smallest = new int[m][n];

        smallest[m - 1][n - 1] = grid.get(m-1).get(n-1);

        // Fill the last column of the smallest array
        for (int i = m - 2; i >= 0; i--) {
            smallest[i][n - 1] = Math.max(grid.get(i).get(n-1), smallest[i + 1][n - 1]);
        }

        // Fill the last row of the smallest array
        for (int j = n - 2; j >= 0; j--) {
            smallest[m - 1][j] = Math.max(grid.get(m-1).get(j), smallest[m - 1][j + 1]);
        }

        // Fill the rest of the array
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                smallest[i][j] = Math.max(grid.get(i).get(j), Math.max(smallest[i + 1][j], smallest[i][j + 1]));
            }
        }
        int res = Integer.MIN_VALUE;
        
        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                int max = Integer.MIN_VALUE;
                if(i==m-1 && j==n-1)
                    continue;
                if(i == m-1)
                    max = smallest[i][j+1];
                else if(j==n-1){
                    max = smallest[i+1][j];
                }else{
                    max = Math.max(smallest[i][j+1], smallest[i+1][j]);
                }
                int score = max - grid.get(i).get(j);
                res = (res<score)?score:res;
                // System.out.print(smallest[i][j]+" ");
            }
            // System.out.println();
        }
        
        return res;
    }
}