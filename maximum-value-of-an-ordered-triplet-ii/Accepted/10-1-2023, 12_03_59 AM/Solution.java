// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii

class Solution {
    public long maximumTripletValue(int[] nums) {        
        int n = nums.length;
        int[] maxFromRight = new int[n];
        maxFromRight[n - 1] = nums[n - 1];

        for (int i=n-2;i>=0;i--) {
            maxFromRight[i] = Math.max(maxFromRight[i+1],nums[i]);
        }

        long maxTripletValue = 0;
        int curMax = nums[0];

        for (int i=0;i<n-1;i++) {
            maxTripletValue = Math.max(maxTripletValue, (long)(curMax-nums[i])*maxFromRight[i + 1]);
            curMax = Math.max(curMax, nums[i]);
        }

        return maxTripletValue;
    }
}