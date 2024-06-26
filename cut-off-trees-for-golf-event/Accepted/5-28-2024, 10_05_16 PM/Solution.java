// https://leetcode.com/problems/cut-off-trees-for-golf-event

class Solution {
    
    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};
    
    public int cutOffTree(List<List<Integer>> forest) {
        int res = 0;
        int m = forest.size();
        int n = forest.get(0).size();
        
        List<Integer> heights = new ArrayList<>();
        for(List<Integer> x:forest){
            for(int val: x){
                if(val>1)
                    heights.add(val);
            }
        }
        
        Collections.sort(heights);
        
        int i = 0, j = 0;

        for (int target: heights) {
            boolean found = false;
            boolean[][] visited = new boolean[m][n];
			
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{i, j});
        
            int steps = -1;
            while (!q.isEmpty() && !found) {
                steps++;
				
				int size = q.size();
                while (size-- > 0) {
                    int[] cur = q.poll();
					
                    if (visited[cur[0]][cur[1]]) 
                        continue;
                    visited[cur[0]][cur[1]] = true;
                    
                    if (forest.get(cur[0]).get(cur[1]) == 0) 
                        continue;
                    
					if (forest.get(cur[0]).get(cur[1]) == target) {
                        i = cur[0];
                        j = cur[1];
                        found = true;
                        break;
                    }

                    for (int k = 0; k < 4; k++) {
                        int x = cur[0] + dx[k];
                        int y = cur[1] + dy[k];
						
                        if (x<0 || y<0 || x>=m || y >= n || visited[x][y] || forest.get(x).get(y) == 0)   
                            continue;
                        q.offer(new int[]{x, y});
                    }
                }
            }
            if (steps == -1 || !found) 
                return -1;

			res += steps;
        }
        
        return res;
    }
}