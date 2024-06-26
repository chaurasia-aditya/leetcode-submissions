// https://leetcode.com/problems/number-of-provinces

class Solution {
    
    void dfs(int i, int[][] grid, boolean[] visited, int n){
        if(i<0 || i==n){
            return;
        }
        
        visited[i] = true;
                
        for(int k = 0; k<n; k++){
            if(!visited[k] && grid[i][k] == 1){
                dfs(k, grid, visited, n);
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        int n = isConnected.length;
        int j;
        
        boolean[] visited = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                res++;
                dfs(i, isConnected, visited, n);
            }
        }
        
        return res;
    }
}