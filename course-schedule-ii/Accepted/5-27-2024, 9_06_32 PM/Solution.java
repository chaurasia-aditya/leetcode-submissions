// https://leetcode.com/problems/course-schedule-ii

class Solution {
    public boolean getTopoSort(int i, int n, boolean[] visited, boolean[] recStack, List<List<Integer>> graph, Stack<Integer> st){
        if(recStack[i])
            return true;
        if(visited[i])
            return false;
        
        recStack[i] = true;
        visited[i] = true;
        
        List<Integer> cur = graph.get(i);

        for(Integer c:cur){
            if(getTopoSort(c, n, visited, recStack, graph, st))
                return true;
        }

        recStack[i]= false;
        st.push(i);

        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<>());

        for(int[] cur:prerequisites){
            graph.get(cur[1]).add(cur[0]);
        }

        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
 
        for (int i = 0; i < numCourses; i++)
            if (getTopoSort(i, numCourses, visited, recStack, graph, st))
                return new int[]{};


        int[] res = new int[st.size()];
        int i = 0;
        while (!st.empty()) {
            res[i++] = st.pop();
        }

        return res;
    }
}