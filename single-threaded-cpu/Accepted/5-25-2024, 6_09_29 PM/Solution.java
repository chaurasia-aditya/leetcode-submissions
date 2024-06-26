// https://leetcode.com/problems/single-threaded-cpu

class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] sortTasks = new int[n][3];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[2]!=b[2])?a[2]-b[2]:a[0]-b[0]);

        for(int i = 0; i<n;i++){
            sortTasks[i][0] = i;
            sortTasks[i][1] = tasks[i][0];
            sortTasks[i][2] = tasks[i][1];
        }

        Arrays.sort(sortTasks, (a,b) -> a[1]-b[1]);

        int cur = 0;
        int i = 0;
        int k = 0;
        int[] res = new int[n];

        while(i<n  || !pq.isEmpty()){
            if(pq.isEmpty() && cur<sortTasks[i][1]){
                cur = sortTasks[i][1];
            }
            
            while(i<n && sortTasks[i][1]<=cur)
                pq.add(sortTasks[i++]);
            
            int[] poll = pq.poll();
            cur+=poll[2];
            res[k++] = poll[0];
        }

        return res;
    }
}