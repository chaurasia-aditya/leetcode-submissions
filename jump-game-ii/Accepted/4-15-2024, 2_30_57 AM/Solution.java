// https://leetcode.com/problems/jump-game-ii

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n<=2)
            return n-1;
            
        int max = 0, reach = 0, jumps = 0;;

        for(int i=0;i<nums.length;i++){
            if(i>max){
                max = reach;
                jumps++;
            }
            reach = Math.max(reach, nums[i]+i);

            if(reach >= n-1){
                break;
            }
        }
        return jumps+1;
    }
}