// https://leetcode.com/problems/task-scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char ch:tasks)
            count[ch-'A']++;
                
        Arrays.sort(count);
        int max = count[25]-1;
        int idleSlots = n*max;

        for(int i=24;i>=0;i--){
            idleSlots-=Math.min(count[i], max);
        }

        return idleSlots>0?idleSlots+tasks.length:tasks.length;

    }
}