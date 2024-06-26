// https://leetcode.com/problems/single-number-ii

class Solution {
    public int singleNumber(int[] nums) {
        // int res = 0;

        // for(int i=0;i<32;i++){
        //     int count = 0;
        //     for(int num:nums)
        //         count+=((num>>i)&1);
        //     count%=3;
        //     res |= (count<<i);
        // }

        // return res;
    
        int one = 0, two = 0;

        for(int num: nums){
            one = (one^num)&(~two);
            two = (two^num)&(~one);
        }

        return one;
    }

}