// https://leetcode.com/problems/count-number-of-nice-subarrays

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int res = 0, cur = 0;

        for(int i=0, j=0;j<n;j++){
            if((nums[j]&1)==1){
                k--;
                cur = 0;
            }
            while(k == 0){
                cur++;
                k+= (nums[i++] % 2);
            }

            res+= cur;
        }

        return res;
    }
}