// https://leetcode.com/problems/partition-equal-subset-sum

class Solution {
    Boolean[][] memo;
    boolean check(int in, int n, int[] nums, int target){
        if(target == 0){
            return true;
        }
        if(in >= n || target<0)
            return false;
        
        if(memo[in][target]!=null)
            return memo[in][target];
        
        return memo[in][target] = check(in+1, n, nums, target-nums[in]) || check(in+1, n, nums, target);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums)
            sum+=num;
        if((sum&1) == 1)
            return false;

        memo = new Boolean[nums.length+1][sum/2+1];

        return check(0, nums.length, nums, sum/2);
    }
}