// https://leetcode.com/problems/path-with-minimum-effort

class Solution {
    public int minimumEffortPath(int[][] grid) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        int rows = grid.length;
        int cols = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        int[][] effort = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }
        effort[0][0] = 0;

        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];
            int path_effort = cur[2];

            if (cur_x == rows-1 && cur_y == cols-1) {
                return path_effort;
            }

            for(int i=0;i<4;i++){
                int new_x = cur_x+dx[i];
                int new_y = cur_y+dy[i];

                if(new_x>=0 && new_y>=0 && new_x<rows && new_y<cols){
                    int new_effort = Math.max(path_effort, Math.abs(grid[new_x][new_y]-grid[cur_x][cur_y]));

                    if(new_effort<effort[new_x][new_y]){
                        effort[new_x][new_y] = new_effort;
                        pq.offer(new int[]{new_x, new_y, new_effort});
                    }
                }
            }
        }

        return -1;
    }
}