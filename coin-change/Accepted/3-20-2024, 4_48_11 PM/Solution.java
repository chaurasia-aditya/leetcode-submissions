// https://leetcode.com/problems/coin-change

class Solution {
    int min = Integer.MAX_VALUE;
    int recur(int left, int[] dp, int[] coins, int n){
        if(left<0)
            return Integer.MAX_VALUE;
        else if(left==0){
            return 0;
        }

        if(dp[left]!=-1)
            return dp[left];

        int cur_min = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
           int res = recur(left-coins[i], dp, coins, n);

           if(res!=Integer.MAX_VALUE){
                cur_min = Math.min(cur_min, res+1);
           }
        }
        return dp[left]=cur_min;
    }
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        
        int n = coins.length;

        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        
        int res = recur(amount, dp, coins, n);

        return (res==Integer.MAX_VALUE?-1:res);
    }
}