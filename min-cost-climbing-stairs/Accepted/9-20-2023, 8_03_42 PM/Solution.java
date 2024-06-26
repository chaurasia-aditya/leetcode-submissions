// https://leetcode.com/problems/min-cost-climbing-stairs

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length<2)
            return 0;
        int[] min = new int[cost.length+1];
        min[0] = min[1] = 0;
        for(int i = 2;i<=cost.length;i++){
            min[i] = Math.min(min[i-1]+cost[i-1], min[i-2]+cost[i-2]);
        }
        return min[cost.length];
    }
}