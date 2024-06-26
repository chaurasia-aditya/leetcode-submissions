// https://leetcode.com/problems/maximize-total-cost-of-alternating-subarrays

class Solution {
    public long maximumTotalCost(int[] nums) {
        int n = nums.length;

        long add = nums[0];
        long sub = nums[0];

        for(int i=1;i<n;i++){
            long temp1 = Math.max(add, sub)+nums[i];
            long temp2 = add-nums[i];
            add = temp1;
            sub = temp2;
        }

        return Math.max(add, sub);
    }
}