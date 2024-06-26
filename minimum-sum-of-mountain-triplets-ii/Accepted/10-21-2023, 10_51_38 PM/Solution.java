// https://leetcode.com/problems/minimum-sum-of-mountain-triplets-ii

class Solution {
    public int minimumSum(int[] nums) {
        int min = nums[0];
        int min2[] = new int[nums.length];
        int res = -1;
        min2[nums.length-1] = Integer.MAX_VALUE;
        for(int i=nums.length-2;i>=0;i--){
            min2[i] = Math.min(min2[i+1], nums[i+1]);
        }
        for(int j=1;j<nums.length-1;j++){
            min = Math.min(min, nums[j-1]);
            if(min2[j] >= nums[j] || min >=nums[j]){
                continue;
            }
            if(res == -1){
                // System.out.println("j="+j+" res = "+res+" min = "+min+" min2 = "+min2[j]);
                res = min+min2[j]+nums[j];
            }
            else{
                // System.out.println("j="+j+" res = "+res+" min = "+min+" min2 = "+min2[j]);
                res = Math.min(res, min+min2[j]+nums[j]);
            }
        }
        return res;
    }
}