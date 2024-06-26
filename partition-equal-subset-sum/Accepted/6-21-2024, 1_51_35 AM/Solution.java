// https://leetcode.com/problems/partition-equal-subset-sum

class Solution {
    Boolean[][] memo;
    public boolean isPossible(int i, int n, int[] nums, int target){
        if(target == 0)
            return true;
        
        if(i>=n || target<0)
            return false;

        if(memo[i][target] != null)
            return memo[i][target];
        
        return memo[i][target] = (isPossible(i+1, n, nums, target-nums[i])||isPossible(i+1, n, nums, target));
    }

    public boolean canPartition(int[] nums) {
        int total = 0;

        for(int num:nums)
            total+=num;
        
        if((total&1)==1)
            return false;
        
        memo = new Boolean[nums.length][total/2+1];
        
        return isPossible(0, nums.length, nums, total/2);
    }
}