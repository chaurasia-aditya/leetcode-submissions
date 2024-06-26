// https://leetcode.com/problems/two-city-scheduling

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length/2;
        int[] refund = new int[2*n];
        
        int min = 0, index = 0;
        
        for(int[] cost : costs){
            refund[index++] = cost[1] - cost[0];
            min += cost[0];
        }
        
        Arrays.sort(refund);
        
        for(int i = 0; i < n; i++){
            min += refund[i];
        }
        return min;
    }
}