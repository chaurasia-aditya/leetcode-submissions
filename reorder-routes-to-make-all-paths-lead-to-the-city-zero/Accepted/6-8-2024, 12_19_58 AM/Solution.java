// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero

class Solution {

    int dfs(int cur, int n, boolean[] visited, List<List<Integer>> graph){      
        visited[cur] = true;
        List<Integer> conn = graph.get(cur);

        int count = 0;

        for(int i:conn){
            if(!visited[Math.abs(i)]){
                count+=(dfs(Math.abs(i), n, visited, graph));
                if(i>0)
                    count++;
            }
             
        }

        return count;        
    }

    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        for(int[] cur:connections){
            graph.get(cur[0]).add(cur[1]);
            graph.get(cur[1]).add(-cur[0]);
        }

        boolean[] visited = new boolean[n];

        return dfs(0, n, visited, graph);
    }
}