// https://leetcode.com/problems/number-of-islands

class Solution {
    boolean[][] visited;
    void dfs(int i, int j, char[][] grid){
        visited[i][j] = true;

        if(i>=1 && grid[i-1][j] == '1' && !visited[i-1][j]){
            dfs(i-1, j, grid);
        }
        if(i<grid.length-1 && grid[i+1][j] == '1' && !visited[i+1][j]){
            dfs(i+1, j, grid);
        }
        if(j>=1 && grid[i][j-1] == '1' && !visited[i][j-1]){
            dfs(i, j-1, grid);
        }
        if(j<grid[0].length-1 && grid[i][j+1] == '1' && !visited[i][j+1]){
            dfs(i, j+1, grid);
        }
    }
    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
}