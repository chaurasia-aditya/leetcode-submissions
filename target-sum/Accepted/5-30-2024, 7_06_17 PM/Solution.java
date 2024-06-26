// https://leetcode.com/problems/target-sum

class Solution {
    int count(int pos, int n, int target, int[] nums, int cur){
        if(pos == n)
            if(cur==target)
                return 1;
            else
                return 0;

        int res=count(pos+1, n, target, nums, cur+nums[pos]) + count(pos+1, n, target, nums, cur-nums[pos]);
        return res;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        return count(0, n, target, nums, 0);
    }
}