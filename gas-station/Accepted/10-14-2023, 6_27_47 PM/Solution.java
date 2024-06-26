// https://leetcode.com/problems/gas-station

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0, cur = 0, max = 0;
        for(int i=0;i<cost.length;i++){
            int diff = gas[i] - cost[i];
            cur+=diff;
            max+=diff;
            if(cur<0){ // At index i gas went below cost. So we can't start before i.
                cur=0;
                index = i+1;
            }
        }
        if(max<0)
            return -1;
        return index;
    }
}