// https://leetcode.com/problems/jump-game

class Solution {
    public boolean canJump(int[] nums) {
        boolean[] reached = new boolean[nums.length];
        reached[0] = true;
        for(int i=0;i<nums.length;i++){
            if(reached[i] == true){
                for(int j=1;j<=nums[i] && (i+j<nums.length);j++){
                    reached[i+j] = true;
                }
            }
        }
        return reached[nums.length-1];
    }
}