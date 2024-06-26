// https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        boolean dec = false;
        int max = 1;
        int st = 0, i = 1;
        for(;i<nums.length;i++){
            if((dec && nums[i]>nums[i-1])||(!dec && nums[i]<nums[i-1])){
                dec = !dec;
                max = Math.max(i-st, max);
                st = i-1;
            }else if(nums[i]==nums[i-1]){
                max = Math.max(i-st, max);
                st = i;
            }
        }

        max = Math.max(i-st, max);

        return max;
    }
}