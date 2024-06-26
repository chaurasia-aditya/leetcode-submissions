// https://leetcode.com/problems/minimum-size-subarray-sum

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i,j, cur_sum=0, min = Integer.MAX_VALUE;
        for(i = 0, j=0;i<nums.length;){
            if(cur_sum>=target){
                min = Math.min(min, j-i);
                cur_sum-=nums[i];
                i++;
                continue;
            }
            if(j==nums.length)
                break;
            cur_sum+=nums[j];
            j++;
        }
        if(min == Integer.MAX_VALUE)
            return 0;
        return min;
    }
}