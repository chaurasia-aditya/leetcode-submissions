// https://leetcode.com/problems/jump-game-ii

class Solution {
    public int jump(int[] nums) {
        if(nums.length-1 <= 1)
            return nums.length-1;
        int jump_max = 0, reach = 0, jumps = 0;
        for(int i=0;i<nums.length;i++){
            if(i>jump_max){
                jump_max = reach;
                jumps++;
            }
            reach = Math.max(reach, i+nums[i]);
            
            if(reach>=nums.length-1)
                break;
        }
        System.gc();
        return jumps+1;
    }
}