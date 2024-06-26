// https://leetcode.com/problems/find-the-k-or-of-an-array

class Solution {
    public int findKOr(int[] nums, int k) {
        int[] set = new int[33];
        int j = 0;
        for(int i=0;i<nums.length;i++){
            int cur = nums[i];
            j=0;
            while(cur>0){
                set[j]+=((cur&1) == 1)?1:0;
                cur>>=1;
                j++;
            }
        }
        int res = 0;
        for(int i=31;i>=0;i--){
            if(set[i] >=k)
                res+=Math.pow(2,i);
        }
        return res;
    }
}