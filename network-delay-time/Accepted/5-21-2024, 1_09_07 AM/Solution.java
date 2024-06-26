// https://leetcode.com/problems/network-delay-time

class Solution {
    int MAX = 100*100*6000;
    class Pair{
        int dest, weight;
        
        public Pair(int d, int w){
            dest = d;
            weight = w;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {        
        List<List<Pair>> al = new ArrayList<>();
 
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }
                
        for(int i=0;i<times.length;i++){
            al.get(times[i][0]-1).add(new Pair(times[i][1]-1, times[i][2]));
            // grid[][time[i][1]-1] = times[i][2];
        }
        
        int[] dist = new int[n];

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
            dist[i] = MAX;
        }
        
        dist[k-1] = 0;
        int current = k-1;
 

        Set<Integer> sett = new HashSet<>();
        while (true) {
            visited[current] = true;
            for (int i = 0; i < al.get(current).size(); i++) {
                int v = al.get(current).get(i).dest;
 
                if (visited[v])
                    continue;

                sett.add(v);
                int alt = dist[current] + al.get(current).get(i).weight;

                if (alt < dist[v]) {
                    dist[v] = alt;
                }
            }
            sett.remove(current);
 
            if (sett.isEmpty())
                break;
 
            int minDist = MAX;
            int index = 0;

            for (int a : sett) {
                if (dist[a] < minDist) {
                    minDist = dist[a];
                    index = a;
                }
            }
            current = index;
        }
        
        int max = -1;
        
        for(int i:dist){
            if(i>=MAX)
                return -1;
            max=Math.max(i, max);
        }
        
        return max;
    }
}