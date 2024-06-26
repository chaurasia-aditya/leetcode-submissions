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
        memo = new Boolean[n];

        return check(0, n, nums);
    }
}