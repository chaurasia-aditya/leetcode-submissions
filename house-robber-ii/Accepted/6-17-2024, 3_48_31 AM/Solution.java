// https://leetcode.com/problems/house-robber-ii

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums[0];
        else if(n == 2){
            return Math.max(nums[0], nums[1]);
        }

        int[] dp0 = new int[n-1];
        int[] dp1 = new int[n-1];

        dp0[0] = nums[0];
        dp0[1] = nums[1];
        

        dp1[0] = nums[1];
        dp1[1] = nums[2];

        if(n>3){
            dp0[2] = nums[0]+nums[2];
            dp1[2] = nums[1]+nums[3];
        }

        for(int i=3;i<n-1;i++){
            dp0[i] = nums[i]+Math.max(dp0[i-2], dp0[i-3]);
        }

        for(int i=3;i<n-1;i++){
            dp1[i] = nums[i+1]+Math.max(dp1[i-2], dp1[i-3]);
        }

        int m1 = Math.max(dp0[n-2], dp0[n-3]);
        int m2 = Math.max(dp1[n-2], dp1[n-3]);

        return Math.max(m1, m2);
    }
}