// https://leetcode.com/problems/single-number-iii

class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;

        for(int num:nums)
            xor^=num;
        
        int f_xor = 0, s_xor = 0;

        int offset = 0;
        while(((xor>>offset) &1)!=1)
            offset++;
        
        for(int num:nums){
            if(((num>>offset) &1) == 1)
                f_xor^=num;
            else
                s_xor^=num;
        }

        return new int[]{f_xor, s_xor};
    }
}