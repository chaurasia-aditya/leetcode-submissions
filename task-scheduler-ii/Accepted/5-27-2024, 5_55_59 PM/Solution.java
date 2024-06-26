// https://leetcode.com/problems/task-scheduler-ii

class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer, Long> hm = new HashMap<>();
        long res = 0;

        for(int task:tasks){
            long last = hm.getOrDefault(task, 0L);
            if(last==0){
                res++;
            }else if(res-last<space){
                res = last+space+1;
            }else{
                res++;
            }
            hm.put(task, res);
        }

        return res;
    }
}