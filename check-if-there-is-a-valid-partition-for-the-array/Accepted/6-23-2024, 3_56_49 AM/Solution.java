// https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array

class Solution {
    Boolean[] memo;
    boolean check(int i, int n, int[] nums){
        if(i == n)
            return true;
        if(memo[i]!=null)
            return memo[i];
        
        boolean res = false;

        if(i+1<n && nums[i+1] == nums[i])
            res |= check(i+2, n, nums);

        if(!res && i+2<n && nums[i+1] == nums[i] && nums[i+2] == nums[i])
            res |= check(i+3, n, nums);
        
        if(!res && i+2<n && nums[i+1] == nums[i]+1 && nums[i+2] == nums[i]+2)
            res |= check(i+3, n, nums);

        return memo[i] = res;
    }

    public boolean validPartition(int[] nums) {
        int n = nums.length;
        if(n<=1)
            return false;
        if(n == 2)
            return (nums[0] == nums[1]);

        boolean[] dp = new boolean[n];

        dp[1] = (nums[0] == nums[1]);
        dp[2] = (nums[0] == nums[1] && nums[0] == nums[2]) ||(nums[1] == nums[0]+1 && nums[2] == nums[0]+2);
        
        for(int i=3;i<n;i++){
            if(dp[i-2] && (nums[i-1] == nums[i]))
                dp[i] = true;
            else if(dp[i-3] && (nums[i-1] == nums[i] && nums[i-2] == nums[i]))
                dp[i] = true;
            else if(dp[i-3] && (nums[i-1] == nums[i]-1 && nums[i-2] == nums[i]-2))
                dp[i] = true;
        }

        return dp[n-1];
    }
}