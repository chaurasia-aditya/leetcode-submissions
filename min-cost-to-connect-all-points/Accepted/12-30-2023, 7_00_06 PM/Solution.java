// https://leetcode.com/problems/min-cost-to-connect-all-points

class Solution {
    int V;
    int minKey(int key[], boolean mstSet[])
    {
        int min = Integer.MAX_VALUE, min_index = -1;
 
        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }
 
        return min_index;
    }

    int prim(int graph[][])
    {
        int cost=0;
        int parent[] = new int[V];
        int key[] = new int[V];
        boolean mstSet[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;
 
        for (int count = 0; count < V - 1; count++) {

            int u = minKey(key, mstSet);

            mstSet[u] = true;
            for (int v = 0; v < V; v++)
                if (graph[u][v] != 0 && mstSet[v] == false
                    && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }
        
        for (int i = 1; i < V; i++){
            cost+=graph[i][parent[i]];
        }

        return cost;        
    }

    public int minCostConnectPoints(int[][] points) {
        V = points.length;
        int[][] graph = new int[V][V];

        for(int i=0;i<V;i++){
            graph[i][i] = 0;
            for(int j=i+1;j<V;j++){
                int dist = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                graph[i][j] = graph[j][i] = dist;
            }
        }

        return prim(graph);
    }
}