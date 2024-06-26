// https://leetcode.com/problems/cheapest-flights-within-k-stops

class Solution {
    class Pair{
        int node, cost;

        Pair(int n, int c){
            node = n;
            cost = c;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        int[][] grid = new int[n][n];

        for(int[] f:flights){
            grid[f[0]][f[1]] = f[2];
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));

        k++;

        while(!q.isEmpty() && k>0){
            int size = q.size();

            while(size-->0){
                Pair cur = q.poll();
                for(int i=0;i<n;i++){
                    if(grid[cur.node][i] != 0 && cur.cost+grid[cur.node][i]<cost[i]){
                        q.offer(new Pair(i, cur.cost+grid[cur.node][i]));
                        cost[i] = cur.cost+grid[cur.node][i];
                    }
                }
            }

            k--;
        }

        return cost[dst] == Integer.MAX_VALUE?-1:cost[dst];
    }
}