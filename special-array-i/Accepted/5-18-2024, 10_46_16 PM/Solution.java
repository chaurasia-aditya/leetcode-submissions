// https://leetcode.com/problems/special-array-i

class Solution {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length==1)
            return true;
        int parity = (nums[0]&1);
        
        for(int i=1;i<nums.length;i++){
            if((parity^(nums[i]&1)) == 0)
                return false;
            parity = (nums[i]&1);
        }
        
        return true;
        
    }
}