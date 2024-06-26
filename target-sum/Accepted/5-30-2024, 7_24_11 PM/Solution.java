// https://leetcode.com/problems/target-sum

class Solution {
    int count(int pos, int n, int target, int[] nums, int cur){
        if(pos == n)
            if(cur==target)
                return 1;
            else
                return 0;
        if(cur>target)
            return 0;

        int res=count(pos+1, n, target, nums, cur+nums[pos]) + count(pos+1, n, target, nums, cur);
        return res;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;

        for(int i: nums)
            total+=i;
        
        if(total<target || (total-target)%2 == 1)
            return 0;
        
        int reduce = (total-target)/2;

        return count(0, n, reduce, nums, 0);
    }
}