// https://leetcode.com/problems/minimum-cost-for-tickets

class Solution {
    public int backtrack(int index, int n, int[] days, int[] costs, int[] memo){
        if(index >= n){
            return 0;
        }

        if(memo[index]!=-1)
            return memo[index];
        
        int cost1 = costs[0] + backtrack(index+1, n, days, costs, memo);

        int i = index;

        while(i < n && days[i] < days[index]+7)
            i++;
        int cost7 = costs[1] + backtrack(i, n, days, costs, memo);

        i = index;
        while(i < n && days[i] < days[index]+30)
            i++;
        int cost30 = costs[2] + backtrack(i, n, days, costs, memo);
        
        return memo[index] = Math.min(cost1, Math.min(cost7, cost30));  
    }
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;

        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);

        return backtrack(0, n, days, costs, memo);
    }
}