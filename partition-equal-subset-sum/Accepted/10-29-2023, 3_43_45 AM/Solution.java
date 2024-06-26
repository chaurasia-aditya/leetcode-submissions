// https://leetcode.com/problems/partition-equal-subset-sum

class Solution {
    int sum = 0;
    boolean isPossible = false;
    Boolean mem[][];
    boolean dfs(int[] nums, int idx, int rem){
        if(rem == 0){
            return true;
        }else if(idx == nums.length || rem<0){
            return false;
        }
        if(mem[idx][rem]!=null)
            return mem[idx][rem];
        return mem[idx][rem] = dfs(nums, idx+1, rem-nums[idx]) || dfs(nums, idx+1, rem);
    }
    public boolean canPartition(int[] nums) {
        for(int n:nums){
            sum+=n;
        }
        if((sum&1)==1)
            return false;
        
        mem = new Boolean[nums.length+1][sum/2+1];

        return dfs(nums, 0, sum/2);
    }
}