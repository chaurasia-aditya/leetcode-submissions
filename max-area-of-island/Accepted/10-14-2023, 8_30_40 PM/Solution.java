// https://leetcode.com/problems/max-area-of-island

class Solution {
    int dfs(int i, int j, int[][] grid, int n, int m){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j] == 0)
            return 0;    

        grid[i][j] = 0;
        return 1+dfs(i-1, j, grid, n, m)+dfs(i+1, j, grid, n, m)+dfs(i, j-1, grid, n, m)+dfs(i, j+1, grid, n, m);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int max = 0;

        for(int i=0; i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    max = Math.max(max, dfs(i, j, grid, n, m));
                }
            }
        }
        return max;
    }
}