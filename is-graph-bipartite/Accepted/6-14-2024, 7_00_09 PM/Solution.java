// https://leetcode.com/problems/is-graph-bipartite

class Solution {
    boolean isBipartiteDfs(int index, int cur, int[] colour, int[][] graph){
        colour[index] = cur;

        int[] adj = graph[index];
        boolean res = true;

        for(int i:adj){
            if(colour[i] == -1){
                res &= isBipartiteDfs(i, 1-cur, colour, graph);
            }else if(colour[i] == cur){
                return false;
            }

            if(!res)
                return false; 
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colour = new int[n];
        Arrays.fill(colour, -1);

        for(int i=0;i<n;i++){
            if(colour[i] == -1){
                if(!isBipartiteDfs(i, 0, colour, graph)){
                    return false;
                }
            }
        }

        return true;
    }
}