// https://leetcode.com/problems/shortest-bridge

class Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};

    class Pair{
        int i,j;

        public Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    void dfs(int i, int j, int n, int[][] grid, Queue<Pair> q){
        if(i<0 || i>=n || j<0 || j>=n || grid[i][j]!=1)
            return;
        
        grid[i][j] = 2;
        q.offer(new Pair(i, j));

        dfs(i+1, j, n, grid, q);
        dfs(i, j+1, n, grid, q);
        dfs(i-1, j, n, grid, q);
        dfs(i, j-1, n, grid, q);
    }

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<Pair> q = new LinkedList<>();
        int x = 2;
        int j;
        for(int i=0;i<n;i++){
            j=0;
            for(;j<n;j++){
                if(grid[i][j] == 1){
                    dfs(i, j, n, grid, q);
                    break;
                }
            }
            if(j!=n)
                break;
        }

        int count = 0;
        int cur_i, cur_j, new_i, new_j;

        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Pair cur = q.poll();
                cur_i = cur.i;
                cur_j = cur.j;

                for(int i=0;i<4;i++){
                    new_i = cur_i+dx[i];
                    new_j = cur_j+dy[i];

                    if(new_i>=0 && new_i<n && new_j>=0 && new_j<n){
                        if(grid[new_i][new_j] == 0){
                            q.add(new Pair(new_i, new_j));
                            grid[new_i][new_j] = 2;
                        }else if(grid[new_i][new_j] == 1){
                            return count;
                        }
                    }
                }
            }
            count++;
        }
        return count;
    }
}