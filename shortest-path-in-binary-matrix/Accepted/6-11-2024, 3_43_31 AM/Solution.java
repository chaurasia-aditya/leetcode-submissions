// https://leetcode.com/problems/shortest-path-in-binary-matrix

class Solution {
    int[] dx = new int[]{0, 0, 1, -1, 1, 1, -1, -1};
    int[] dy = new int[]{1, -1, 0, 0, 1, -1, -1, 1};

    class Pair{
        int i,j;

        public Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1]==1)
            return -1;
        if(n==1)
            return 1;

        Queue<Pair> q = new LinkedList<>();
        int count = 1;
        int cur_i, cur_j, new_i, new_j;

        q.offer(new Pair(0, 0));
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Pair cur = q.poll();
                cur_i = cur.i;
                cur_j = cur.j;

                for(int i=0;i<8;i++){
                    new_i = cur_i+dx[i];
                    new_j = cur_j+dy[i];

                    if(new_i>=0 && new_i<n && new_j>=0 && new_j<n && grid[new_i][new_j] == 0){
                        if(new_i == n-1 && new_j==n-1)
                            return count+1;
                        q.add(new Pair(new_i, new_j));
                        grid[new_i][new_j] = 2;
                    }
                }
            }
            count++;
        }
        return -1;
    }
}