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

    public int maximumSafenessFactor(List<List<Integer>> g) {
        int n = g.size();

        if(g.get(0).get(0) == 1 || g.get(n-1).get(n-1) == 1)
            return 0;
        
        int[][] grid = new int[n][n];
        for(int[] gr: grid)
            Arrays.fill(gr, 1001);

        Queue<Cell> q = new LinkedList<>();

        int i = 0, j=0;
        for(List<Integer> r:g){
            j=0;
            for(Integer v: r){
                if(v == 1){
                    grid[i][j] = 0;
                    q.offer(new Cell(i, j, 0));
                }
                j++;
            }
            i++;
        }

        while(!q.isEmpty()){
            int size = q.size();

            while(size-->0){
                Cell cur = q.poll();
                int cur_x = cur.x;
                int cur_y = cur.y;
                int cur_dist = cur.dist;

                if(grid[cur_x][cur_y]<cur_dist)
                    continue;

                for(i=0;i<4;i++){
                    int new_x = cur_x+dx[i];
                    int new_y = cur_y+dy[i];

                    if(new_x>=0 && new_y>=0 && new_x<n && new_y<n){
                        if(grid[new_x][new_y] == 0)
                            continue;
                        if(cur_dist+1<grid[new_x][new_y]){
                            grid[new_x][new_y] = cur_dist+1;
                            q.offer(new Cell(new_x, new_y, cur_dist+1));
                        }
                    }
                }
            }
        }

        PriorityQueue<Cell> pq = new PriorityQueue<>((a,b) -> b.dist-a.dist);
        Set<String> visited = new HashSet<>();

        pq.offer(new Cell(0, 0, grid[0][0]));
        visited.add(0 + "," + 0);

        while (!pq.isEmpty()) {
            Cell cur = pq.poll();
            int cur_x = cur.x;
            int cur_y = cur.y;
            int cur_dist = cur.dist;

            if (cur_x == n-1 && cur_y == n-1) {
                return cur_dist;
            }

            for(i=0;i<4;i++){
                int new_x = cur_x+dx[i];
                int new_y = cur_y+dy[i];

                if(new_x>=0 && new_y>=0 && new_x<n && new_y<n && !visited.contains(new_x + "," + new_y)){
                    pq.offer(new Cell(new_x, new_y, Math.min(cur_dist, grid[new_x][new_y])));
                    visited.add(new_x + "," + new_y);
                }
            }
        }

        return -1;
    }
}