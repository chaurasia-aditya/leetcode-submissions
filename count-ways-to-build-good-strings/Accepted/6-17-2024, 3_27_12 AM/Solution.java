// https://leetcode.com/problems/count-ways-to-build-good-strings

class Solution {
    final int MOD = (int)1e9+7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        
        dp[0] = 1;

        int max = zero>one?zero:one;
        int min = zero+one-max;

        for(int i=min;i<max;i++){
            dp[i] = dp[i-min];
        }

        for(int i=max;i<=high;i++){
            dp[i]=(dp[i-min]+dp[i-max])%MOD;
        }

        long res = 0;

        for(int i=low; i<=high; i++){
            res+=dp[i];
        }
        
        return (int)(res%MOD);
    }
}