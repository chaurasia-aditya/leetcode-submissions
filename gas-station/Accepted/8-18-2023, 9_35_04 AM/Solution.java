// https://leetcode.com/problems/gas-station

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int fuel_left = 0, fuel_needed = 0, index = 0;
        for(int i=0;i<gas.length;i++){
            fuel_left+=(gas[i]-cost[i]);
            fuel_needed+=(gas[i]-cost[i]);
            if(fuel_left<0){
                index = i+1;
                fuel_left = 0;
            }
        }
        if(fuel_needed<0)
            return -1;
        return index;
    }
}