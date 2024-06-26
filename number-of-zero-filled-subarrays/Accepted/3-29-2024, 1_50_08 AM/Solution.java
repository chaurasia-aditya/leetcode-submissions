// https://leetcode.com/problems/number-of-zero-filled-subarrays

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;

        int st = -1;
        for(int i =0;i<nums.length;i++){
            if(nums[i] == 0){
                if(st == -1){
                    st = i;
                }
            }else if(st!=-1){
                long n = i-st;
                ans += n*(n+1)/2;
                st = -1;
            }
        }

        if(st!=-1){
            long n = nums.length-st;
            ans += n*(n+1)/2;
        }

        return ans;
    }
}