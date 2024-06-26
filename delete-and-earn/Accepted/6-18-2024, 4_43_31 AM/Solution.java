// https://leetcode.com/problems/delete-and-earn

class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for(int num:nums){
            count[num]++;
        }

        int[] dp = new int[10001];
        dp[0] = 0;
        dp[1] = count[1];

        for(int i=2;i<=10000;i++){
            if(count[i] == 0){
                dp[i] = dp[i-1];
            }else{
                dp[i] = Math.max(dp[i-1], dp[i-2]+count[i]*i);
            }
        }

        return dp[10000];
    }
}