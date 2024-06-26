// https://leetcode.com/problems/shift-2d-grid

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            ArrayList<Integer> cur = new ArrayList<>();
            for(int j=0;j<n;j++){
                cur.add(0);
            }
            res.add(cur);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int nc = (j+k)%n;
                int nr = (i+(j+k)/n)%m;
                res.get(nr).set(nc, grid[i][j]);
            }
        }

        return res;
    }
}