// https://leetcode.com/problems/jump-game

class Solution {
    public boolean canJump(int[] nums) {
        int cur = nums[0];
        for(int i=1;i<nums.length;i++){
            if(cur<i){
                return false;
            }
            cur = Math.max(cur, i+nums[i]);
        }
        return true;
    }
}