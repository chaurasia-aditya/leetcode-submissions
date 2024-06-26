// https://leetcode.com/problems/course-schedule-iv

class Solution {
     public void dfs(int i, List<Integer>[] graph, Set<Integer>[] pre){           
        for(Integer c:graph[i]){
            if(!pre[i].contains(c)){
                pre[i].add(c);
                dfs(c, graph, pre);
                pre[i].addAll(pre[c]);
            }
        }
    }

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        Set<Integer>[] pre = new HashSet[n];

        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
            pre[i] = new HashSet<>();
        }

        for(int[] cur:prerequisites){
            graph[cur[0]].add(cur[1]);
        }

        boolean[] visited = new boolean[n];
 
        for (int i = 0; i < n; i++)
            dfs(i, graph, pre);

        List<Boolean> res = new ArrayList<>();
        for(int[] q:queries){
            res.add(pre[q[0]].contains(q[1]));
        }

        return res;

    }
}