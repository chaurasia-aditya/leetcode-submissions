// https://leetcode.com/problems/min-cost-climbing-stairs

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // if(cost.length<2)
        //     return 0;
        int n = cost.length;
        int[] min = new int[n+1];
        min[0] = min[1] = 0;
        for(int i = 2;i<=n;i++){
            min[i] = Math.min(min[i-1]+cost[i-1], min[i-2]+cost[i-2]);
        }
        return min[n];
    }
}