// https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips

class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flips = 0, res = 0;
        
        int[] flipped = new int[n];

        for(int i=0;i<n;i++){
            if(i>=k)
                flips ^= flipped[i-k];
            if(flips == nums[i]){
                if(i+k > n)
                    return -1;
                flipped[i] = 1;
                flips^=1;
                res++;
            }
        }
        return res;
    }
}