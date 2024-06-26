// https://leetcode.com/problems/course-schedule

class Solution {

    public boolean hasCycle(int i, int n, boolean[] visited, boolean[] recStack, List<List<Integer>> graph){
        if(recStack[i])
            return true;
        if(visited[i])
            return false;
        
        recStack[i] = true;
        visited[i] = true;
        
        List<Integer> cur = graph.get(i);

        for(Integer c:cur){
            if(hasCycle(c, n, visited, recStack, graph))
                return true;
        }

        recStack[i]= false;

        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<>());

        for(int[] cur:prerequisites){
            graph.get(cur[1]).add(cur[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
 
        for (int i = 0; i < numCourses; i++)
            if (hasCycle(i, numCourses, visited, recStack, graph))
                return false;
 
        return true;


    }
}