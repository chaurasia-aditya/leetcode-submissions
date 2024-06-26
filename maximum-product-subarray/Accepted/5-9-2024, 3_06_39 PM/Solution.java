// https://leetcode.com/problems/maximum-product-subarray

class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0)
            return 0;

        int n = nums.length;

        int left=1, right=1;
        int res = nums[0];

        for(int i=0;i<nums.length;i++){

            left = left==0?1:left;
            right = right==0?1:right;

            left *= nums[i];
            right *= nums[n-1-i];

            res = Math.max(res, Math.max(left, right));
        }

        return res;
    }
}