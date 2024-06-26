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
        for(int[] gr: cost)
            Arrays.fill(gr, 1001);

        Queue<Cell> q = new LinkedList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid.get(i).get(j) == 1) {
                    cost[i][j] = 0;
                    q.offer(new Cell(i, j, 0));
                }
            }
        }

        while(!q.isEmpty()){
            int size = q.size();

            while(size-->0){
                Cell cur = q.poll();
                int cur_x = cur.x;
                int cur_y = cur.y;
                int cur_dist = cur.dist;

                if(cost[cur_x][cur_y]<cur_dist)
                    continue;

                for(int i=0;i<4;i++){
                    int new_x = cur_x+dx[i];
                    int new_y = cur_y+dy[i];

                    if(new_x>=0 && new_y>=0 && new_x<n && new_y<n){
                        if(cost[new_x][new_y] == 0)
                            continue;
                        if(cur_dist+1<cost[new_x][new_y]){
                            cost[new_x][new_y] = cur_dist+1;
                            q.offer(new Cell(new_x, new_y, cur_dist+1));
                        }
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