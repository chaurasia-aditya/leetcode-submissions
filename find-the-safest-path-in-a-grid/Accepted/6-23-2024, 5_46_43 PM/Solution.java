// https://leetcode.com/problems/find-the-safest-path-in-a-grid

class Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};

    class Cell{
        int x, y;
        int dist;
        Cell(int i, int j, int c){
            x = i;
            y = j;
            dist = c;
        }
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        if(grid.get(0).get(0) == 1 || grid.get(n-1).get(n-1) == 1)
            return 0;
        
        int[][] cost = new int[n][n];
        for(int[] row: cost)
            Arrays.fill(row, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid.get(i).get(j) == 1) {
                    cost[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()){
            int size = q.size();

            while(size-->0){
                int[] cur = q.poll();
                int cur_x = cur[0];
                int cur_y = cur[1];
                int cur_dist = cost[cur_x][cur_y];

                // if(cost[cur_x][cur_y]<cur_dist)
                //     continue;

                for(int i=0;i<4;i++){
                    int new_x = cur_x+dx[i];
                    int new_y = cur_y+dy[i];

                    if(new_x>=0 && new_y>=0 && new_x<n && new_y<n && cost[new_x][new_y]>cur_dist+1){
                        cost[new_x][new_y] = cur_dist+1;
                        q.offer(new int[]{new_x, new_y});
                    }
                }
            }
        }

        PriorityQueue<Cell> pq = new PriorityQueue<>((a,b) -> b.dist-a.dist);
        Set<String> visited = new HashSet<>();

        pq.offer(new Cell(0, 0, cost[0][0]));
        visited.add(0 + "," + 0);

        while (!pq.isEmpty()) {
            Cell cur = pq.poll();
            int cur_x = cur.x;
            int cur_y = cur.y;
            int cur_dist = cur.dist;

            if (cur_x == n-1 && cur_y == n-1) {
                return cur_dist;
            }

            for(int i=0;i<4;i++){
                int new_x = cur_x+dx[i];
                int new_y = cur_y+dy[i];

                if(new_x>=0 && new_y>=0 && new_x<n && new_y<n && !visited.contains(new_x + "," + new_y)){
                    pq.offer(new Cell(new_x, new_y, Math.min(cur_dist, cost[new_x][new_y])));
                    visited.add(new_x + "," + new_y);
                }
            }
        }

        return -1;
    }
}