// https://leetcode.com/problems/pacific-atlantic-water-flow

class Solution {
    public void explore(int i, int j, int[][] heights, boolean[][] visited, int m, int n, int par){
        if(i<0||j<0||i==m||j==n||visited[i][j]||heights[i][j]<par){
            return;
        }
        
        visited[i][j] = true;
        explore(i-1,j, heights, visited, m, n, heights[i][j]);
        explore(i+1,j, heights, visited, m, n, heights[i][j]);
        explore(i,j+1, heights, visited, m, n, heights[i][j]);
        explore(i,j-1, heights, visited, m, n, heights[i][j]);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] atl = new boolean[m][n];
        boolean[][] pac = new boolean[m][n];
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<m;i++){
            explore(i, 0, heights, pac, m, n, heights[i][0]);
            explore(i, n-1, heights, atl, m, n, heights[i][n-1]);
        }
        for(int i=0;i<n;i++){
            explore(0, i, heights, pac, m, n, heights[0][i]);
            explore(m-1, i, heights, atl, m, n, heights[m-1][i]);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pac[i][j] && atl[i][j])
                    res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }
}