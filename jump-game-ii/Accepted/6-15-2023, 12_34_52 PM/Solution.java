// https://leetcode.com/problems/jump-game-ii

class Solution {
    public int jump(int[] nums) {
        int[] count = new int[nums.length];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[0] = 0;
        for(int i=0;i<nums.length-1;i++){
            if(count[i] == Integer.MAX_VALUE)
                continue;
            for(int j=1;j<=nums[i] && i+j<nums.length;j++){
                count[i+j] = Math.min(count[i+j], count[i]+1);
            }
        }
        return count[nums.length-1];
    }
}