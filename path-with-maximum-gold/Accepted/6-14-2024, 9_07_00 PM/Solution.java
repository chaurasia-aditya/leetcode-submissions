// https://leetcode.com/problems/path-with-maximum-gold

class Solution {
    int dfs(int i, int j, int m, int n, int curSum, int[][] grid){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] <= 0){
            return curSum;
        }

        int val = grid[i][j]+curSum;
        grid[i][j]*=-1;

        int tempMax = Math.max(dfs(i+1, j, m, n, val, grid), 
                        Math.max(dfs(i-1, j, m, n, val, grid), 
                            Math.max(dfs(i, j+1, m, n, val, grid), dfs(i, j-1, m, n, val, grid))));

        grid[i][j]*=-1;
        return tempMax;
    }

    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;

        for(int i=0; i<m; i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] != 0){
                    max = Math.max(max, dfs(i, j, m, n, 0, grid));
                }
            }
        }  

        return max;  
    }
}