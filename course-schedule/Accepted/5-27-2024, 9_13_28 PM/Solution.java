// https://leetcode.com/problems/course-schedule

class Solution {
    
    boolean hasCycle(int i, int n, ArrayList<Integer>[] graph, boolean[] visited, boolean[] curPath){
        visited[i] = true;
        curPath[i] = true;

        ArrayList<Integer> cur = graph[i];

        for(int next: cur){
            if(curPath[next] == true)
                return true;
            if(!visited[next] && hasCycle(next, n, graph, visited, curPath)){
                return true;
            }
        }

        curPath[i] = false;

        return false;
    }

    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] a:prerequisites){
            graph[a[1]].add(a[0]);
        }
        
        boolean[] visited = new boolean[n];
        boolean[] curPath = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i] && hasCycle(i, n, graph, visited, curPath)){
                return false;
            }
        }

        return true;
    }
}