// https://leetcode.com/problems/path-with-maximum-gold

class Solution {
    int max = 0;
    void dfs(int i, int j, int m, int n, int cur, boolean[][] visited, int[][] grid){
        if(i<0 || j<0 || i>=m || j>=n || visited[i][j] || grid[i][j] == 0){
            max = Math.max(max, cur);
            return;
        }

        visited[i][j] = true;
        dfs(i+1, j, m, n, cur+grid[i][j], visited, grid);
        dfs(i-1, j, m, n, cur+grid[i][j], visited, grid);
        dfs(i, j+1, m, n, cur+grid[i][j], visited, grid);
        dfs(i, j-1, m, n, cur+grid[i][j], visited, grid);
        visited[i][j] = false;
    }

    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] != 0){
                    dfs(i, j, m, n, 0, new boolean[m][n], grid);
                }
            }
        }  

        return max;  
    }
}