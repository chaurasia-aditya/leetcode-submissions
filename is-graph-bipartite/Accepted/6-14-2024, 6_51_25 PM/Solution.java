// https://leetcode.com/problems/is-graph-bipartite

class Solution {
    boolean isBipartite(int index, int[] colour, int[][] graph){
        Queue<Integer> q = new LinkedList();
        q.offer(index);
        colour[index] = 0;

        while(!q.isEmpty()){
            int temp = q.poll();

            int[] adj = graph[temp];
            for(int i:adj){
                if(colour[i] == -1){
                    colour[i] = 1-colour[temp];
                    q.offer(i);
                }else if(colour[i] == colour[temp]){
                    return false;
                } 
            }
        }

        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colour = new int[n];
        Arrays.fill(colour, -1);

        for(int i=0;i<n;i++){
            if(colour[i] == -1){
                if(!isBipartite(i, colour, graph)){
                    return false;
                }
            }
        }

        return true;
    }
}