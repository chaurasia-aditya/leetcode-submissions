// https://leetcode.com/problems/critical-connections-in-a-network

class Solution {
    int time = 0;
    void dfs(int i, int parent, List<Integer>[] graph, boolean[] visited, int[] disc, int[] low, List<List<Integer>> bridges){
        visited[i] = true;
        disc[i] = time;
        low[i] = time++;
        
        for(int neighbour:graph[i]){
            if(neighbour == parent)
                continue;
            if(!visited[neighbour]){
                dfs(neighbour, i, graph, visited, disc, low, bridges);
                
                low[i] = Math.min(low[i], low[neighbour]);
                if(disc[i]<low[neighbour])
                    bridges.add(Arrays.asList(i, neighbour));
            } else{
                low[i] = Math.min(low[i], disc[neighbour]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new List[n];
        
        List<List<Integer>> bridges = new ArrayList<>();
        
        for(int i=0;i<n;i++)
            graph[i] = new ArrayList<>();
        
        for(List<Integer> x:connections){
            graph[x.get(0)].add(x.get(1));
            graph[x.get(1)].add(x.get(0));
        }
        
        int[] disc = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];
        
        dfs(0, -1, graph, visited, disc, low, bridges);
        
        return bridges;
    }
}