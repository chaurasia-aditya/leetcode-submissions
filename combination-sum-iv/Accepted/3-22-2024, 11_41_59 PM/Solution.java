// https://leetcode.com/problems/combination-sum-iv

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp =new int[target+1];
        dp[0] = 1;

        // for(int num: nums){
        //     System.out.print(num+" || ");
        //     for(int i=0; i<=target-num;i++){
        //         dp[i+num]+=dp[i];
        //     }
        //     for(int k=0;k<=target;k++){
        //         System.out.print(dp[k]+" ");
        //     }
        //     System.out.println();
        // }

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];   
    }
}