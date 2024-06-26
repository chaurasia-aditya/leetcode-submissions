// https://leetcode.com/problems/maximum-difference-score-in-a-grid

class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        
        int[][] largest = new int[m][n];

        largest[m - 1][n - 1] = grid.get(m-1).get(n-1);

        for (int i = m - 2; i >= 0; i--) {
            largest[i][n - 1] = Math.max(grid.get(i).get(n-1), largest[i + 1][n - 1]);
        }

        for (int j = n - 2; j >= 0; j--) {
            largest[m - 1][j] = Math.max(grid.get(m-1).get(j), largest[m - 1][j + 1]);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                largest[i][j] = Math.max(grid.get(i).get(j), Math.max(largest[i + 1][j], largest[i][j + 1]));
            }
        }
        int res = Integer.MIN_VALUE;
        
        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                int max = Integer.MIN_VALUE;
                if(i==m-1 && j==n-1)
                    continue;
                if(i == m-1)
                    max = largest[i][j+1];
                else if(j==n-1){
                    max = largest[i+1][j];
                }else{
                    max = Math.max(largest[i][j+1], largest[i+1][j]);
                }
                int score = max - grid.get(i).get(j);
                res = (res<score)?score:res;
            }
        }
        
        return res;
    }
}