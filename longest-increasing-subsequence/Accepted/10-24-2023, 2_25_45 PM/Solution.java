// https://leetcode.com/problems/longest-increasing-subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        lis[0] = 1;
        int max = 1;
        for(int i=1;i<nums.length;i++){
            lis[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j] && lis[i]<lis[j]+1){
                    lis[i] = lis[j]+1;
                }
            }
            max = Math.max(max, lis[i]);
        }
        return max;
    }
}