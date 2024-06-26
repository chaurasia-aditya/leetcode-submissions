// https://leetcode.com/problems/delete-and-earn

class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];

        int max = 0;

        for(int num:nums){
            count[num]++;
            max = Math.max(max, num);
        }

        int[] dp = new int[max+1];
        
        for(int i=1;i<=max;i++){
            int self = count[i]*i;

            if(i==1){
                dp[i] = self;
            }else{
                dp[i] = Math.max(dp[i-1], dp[i-2]+self);
            }
        }

        return dp[max];
    }
}