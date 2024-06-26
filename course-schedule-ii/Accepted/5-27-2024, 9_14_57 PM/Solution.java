// https://leetcode.com/problems/course-schedule-ii

class Solution {
    public boolean getTopoSort(int i, int n, boolean[] visited, boolean[] curPath, ArrayList<Integer>[] graph, Stack<Integer> st){    
        curPath[i] = true;
        visited[i] = true;
        
        List<Integer> cur = graph[i];

        for(Integer c:cur){
            if(curPath[c] == true)
                return true;
            if(!visited[c] && getTopoSort(c, n, visited, curPath, graph, st))
                return true;
        }

        curPath[i]= false;
        st.push(i);

        return false;
    }

    public int[] findOrder(int n, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i=0;i<n;i++)
            graph[i] = new ArrayList<>();

        for(int[] cur:prerequisites){
            graph[cur[1]].add(cur[0]);
        }

        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[n];
        boolean[] curPath = new boolean[n];
 
        for (int i = 0; i < n; i++)
            if (!visited[i] && getTopoSort(i, n, visited, curPath, graph, st))
                return new int[]{};


        int[] res = new int[st.size()];
        int i = 0;
        while (!st.empty()) {
            res[i++] = st.pop();
        }

        return res;
    }
}