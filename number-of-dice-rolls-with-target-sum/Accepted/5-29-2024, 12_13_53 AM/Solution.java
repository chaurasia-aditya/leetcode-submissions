// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum

class Solution {
    final int MOD = 1000000007;
    int dfs(int n, int k, int rem, int[][] dp){
        if(n == 0 && rem == 0){
            return 1;
        }
        
        if(n<=0 || rem<=0)
            return 0;
        
        if(dp[n][rem]!=-1)
            return dp[n][rem];
        
        int res = 0;
        
        for(int i=1;i<=k;i++){
            res+=(dfs(n-1, k, rem-i, dp));
            res%=MOD;
        }
        
        dp[n][rem] = res;
        return dp[n][rem];
    }
    
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][1000];
        
        for(int i=0;i<=n;i++)
            Arrays.fill(dp[i], -1);
        
        return dfs(n, k, target, dp);
    }
}