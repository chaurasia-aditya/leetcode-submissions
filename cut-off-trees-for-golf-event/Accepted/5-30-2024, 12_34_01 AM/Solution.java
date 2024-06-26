// https://leetcode.com/problems/cut-off-trees-for-golf-event

class Solution {
    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};
    
    class Tree implements Comparable<Tree>{
        int i, j;
        int height;
        
        Tree(int i, int j, int h){
            this.i = i;
            this.j = j;
            height = h;
        }
        
        public int compareTo(Tree b){
            return height-b.height;
        }
    }
    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<Tree> pq = new PriorityQueue<>();
        
        int m = forest.size();
        int n = forest.get(0).size();
        
        for(int i = 0;i<m;i++){
            List<Integer> l = forest.get(i);
            for(int j=0;j<n;j++){
                if(l.get(j)>1)
                    pq.offer(new Tree(i, j, l.get(j)));
            }
        }
        
        int st_i = 0, st_j = 0;
        int count = 0;
        
        
        while(!pq.isEmpty()){
            Tree cur = pq.poll();
            
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{st_i, st_j});
            
            boolean found = false;
            boolean[][] visited = new boolean[m][n];
            int steps = -1;
            
            while(!q.isEmpty() && !found){
                steps++;
                
                int size = q.size();
                
                while(size-->0){
                    int[] curLoc = q.poll();
                    
                    if (visited[curLoc[0]][curLoc[1]]) 
                            continue;
                    visited[curLoc[0]][curLoc[1]] = true;

                    if (forest.get(curLoc[0]).get(curLoc[1]) == 0) 
                        continue;

                    if (curLoc[0] == cur.i && curLoc[1] == cur.j) {
                        st_i = curLoc[0];
                        st_j = curLoc[1];
                        found = true;
                        break;
                    }

                    for (int k = 0; k < 4; k++) {
                        int x = curLoc[0] + dx[k];
                        int y = curLoc[1] + dy[k];

                        if (x<0 || y<0 || x>=m || y >= n || visited[x][y] || forest.get(x).get(y) == 0)   
                            continue;
                        q.offer(new int[]{x, y});
                    }                
                }
            }
            
            if(steps == -1 || !found)
                return -1;
            count+=steps;
        }
        return count;
    }
}