// https://leetcode.com/problems/course-schedule

class Solution {
    
    boolean hasCycle(int i, int n, ArrayList<Integer>[] graph, boolean[] visited, boolean[] curPath){
        if(curPath[i] == true)
            return true;

        if(visited[i])
            return false;

        visited[i] = true;
        curPath[i] = true;

        ArrayList<Integer> cur = graph[i];

        for(int next: cur){
            if(hasCycle(next, n, graph, visited, curPath)){
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
            if(hasCycle(i, n, graph, visited, curPath)){
                return false;
            }
        }

        return true;
    }
}