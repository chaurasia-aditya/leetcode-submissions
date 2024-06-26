// https://leetcode.com/problems/minimum-sum-of-mountain-triplets-i

class Solution {
    public int minimumSum(int[] nums) {
        int min = nums[0];
        int min2 = Integer.MAX_VALUE;
        int res = -1;
        for(int j=1;j<nums.length-1;j++){
            min = Math.min(min, nums[j-1]);
            min2 = Integer.MAX_VALUE;
            if(min>=nums[j]){
                continue;
            }
            for(int k = j+1;k<nums.length;k++){
                if(nums[k]<nums[j]){
                    min2 = Math.min(min2, nums[k]);
                }
            }
            if(min2 >= nums[j]){
                continue;
            }
            if(res == -1){
                res = min+min2+nums[j];
            }
            else{
                res = Math.min(res, min+min2+nums[j]);
            }
        }
        return res;
    }
}