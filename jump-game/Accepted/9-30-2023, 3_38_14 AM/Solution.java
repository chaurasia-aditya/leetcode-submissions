// https://leetcode.com/problems/jump-game

class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1)
            return true;
        int cur = nums[0];
        for(int i=1;i<=cur;i++){
            cur = Math.max(cur, i+nums[i]);
            if(cur>=nums.length-1){
                return true;
            }
        }
        return false;
    }
}