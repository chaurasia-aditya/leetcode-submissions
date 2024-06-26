// https://leetcode.com/problems/sign-of-the-product-of-an-array

class Solution {
    public int arraySign(int[] nums) {
        int neg = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0)
                return 0;
            if(nums[i]<0){
                neg++;
            }
        }
        return (neg&1) == 0?1:-1;
    }
}