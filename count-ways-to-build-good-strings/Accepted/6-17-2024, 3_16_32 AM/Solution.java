// https://leetcode.com/problems/count-ways-to-build-good-strings

class Solution {
    final int MOD = (int)1e9+7;
    public long recur(int len, int low, int high, long[] memo, int zero, int one){
        if(len>high)
            return 0;
        if(memo[len]!=-1)
            return memo[len];
        
        memo[len] = len>=low?1:0;

        memo[len] += recur(len+zero, low, high, memo, zero, one)+recur(len+one, low, high, memo, zero, one);
        
        return memo[len]%MOD;
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] memo = new long[high+1];
        Arrays.fill(memo, -1);
        
        return (int)recur(0, low, high, memo, zero, one);
    }
}