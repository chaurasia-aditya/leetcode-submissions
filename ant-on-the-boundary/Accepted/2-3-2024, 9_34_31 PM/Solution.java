// https://leetcode.com/problems/ant-on-the-boundary

class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int count = 0;
        int cur = 0;
        for(int i=0;i<nums.length;i++){
            cur+=nums[i];
            if(cur == 0){
                count++;
            }
        }
        return count;
    }
}