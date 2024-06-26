// https://leetcode.com/problems/longest-non-decreasing-subarray-from-two-arrays

class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int dp1 = 1, dp2 = 1;

        int a,b,c,d;
        int max = 1; 

        for(int i=1;i<n;i++){
            a = nums1[i]>=nums1[i-1]?dp1+1:1;
            b = nums1[i]>=nums2[i-1]?dp2+1:1;

            c = nums2[i]>=nums2[i-1]?dp2+1:1;
            d = nums2[i]>=nums1[i-1]?dp1+1:1;

            dp1 = Math.max(a,b);
            dp2 = Math.max(c,d);
            max = Math.max(max, Math.max(dp1, dp2));
        } 
        return max;
    }
}