// https://leetcode.com/problems/jump-game

class Solution {
    public boolean canJump(int[] nums) {
        int cur_max = 0; 
        for(int i=0;i<nums.length && i<=cur_max;i++){
            cur_max=Math.max(cur_max,i+nums[i]);
            if(cur_max>=nums.length-1)
                return true;
        }
        return false;
    }
}