// https://leetcode.com/problems/product-of-array-except-self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int cur_prod = 1;
        int [] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = cur_prod;
            cur_prod*=nums[i];
        }
        cur_prod = 1;
        for(int i=n-1;i>=0;i--){
            res[i]*=cur_prod;
            cur_prod*=nums[i];
        }
        return res;
    }
}