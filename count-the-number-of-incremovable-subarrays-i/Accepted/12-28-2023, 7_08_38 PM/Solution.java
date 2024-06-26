// https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-i

class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int res = 0;
        boolean inc;
        int prev;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                inc = true;
                prev = -1;
                for (int k = 0; k < nums.length; k++) {
                    if (k >= i && k <= j) {
                        continue;
                    } else {
                        inc &= (prev < nums[k]);
                        prev = nums[k];
                    }
                }
                res += inc ? 1 : 0;
            }
        }
        return res;
    }
}