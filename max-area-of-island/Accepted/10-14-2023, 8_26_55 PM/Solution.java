// https://leetcode.com/problems/max-area-of-island

class Solution {
    int max = Integer.MIN_VALUE;

    int dfs(int i, int j, int[][] grid, boolean[][] visited, int n, int m){
        if(i<0 || i>=n || j<0 || j>=m || visited[i][j] || grid[i][j] == 0)
            return 0;    

        visited[i][j] = true;
        return 1+dfs(i-1, j, grid, visited, n, m)+dfs(i+1, j, grid, visited, n, m)+dfs(i, j-1, grid, visited, n, m)+dfs(i, j+1, grid, visited, n, m);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    max = Math.max(max, dfs(i, j, grid, visited, n, m));
                }
            }
        }
        return max;
    }
}