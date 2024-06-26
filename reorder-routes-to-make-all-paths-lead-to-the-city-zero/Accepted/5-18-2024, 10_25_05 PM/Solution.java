// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero

class Solution {
    int count = 0;
    
    void dfs(int node, int n, List<List<Integer>> grid, boolean[] visited){
        visited[node] = true;
        for (int j : grid.get(node))
            if (!visited[Math.abs(j)]){
                dfs(Math.abs(j), n, grid, visited);
                if(j>0)
                    count++;
            }
    }
    
    public int minReorder(int n, int[][] connections) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> grid = new ArrayList<>();
        
        for(int i = 0; i < n; i++) 
            grid.add(new ArrayList<>());
        
        for(int i=0;i<connections.length;i++){
            grid.get(connections[i][0]).add(connections[i][1]);
            grid.get(connections[i][1]).add(-connections[i][0]);
        }
        
        dfs(0, n, grid, visited);
        
        return count;
    }
}