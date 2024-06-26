// https://leetcode.com/problems/task-scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        int res = 0;

        for(char ch:tasks)
            count[ch-'A']++;
                
        Arrays.sort(count);

        int idleSlots = n*(count[25]-1);

        for(int i=24;i>=0;i--){
            if(count[i] == 0)
                break;
            idleSlots-=Math.min(count[i], count[25]-1);
        }

        return idleSlots>0?idleSlots+tasks.length:tasks.length;

    }
}