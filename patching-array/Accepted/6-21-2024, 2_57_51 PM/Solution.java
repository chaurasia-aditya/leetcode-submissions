// https://leetcode.com/problems/patching-array

class Solution {
    public int minPatches(int[] nums, int n) {
        int count = 0;
        long sum = 0;
        for (int i = 0; i < nums.length && sum < n; i++) {
            if (nums[i] <= sum + 1) {
                sum += nums[i];
            } else {
                i--;
                count++;
                sum = sum * 2 + 1;
            }
        }
        while (sum < n) {
            sum = sum * 2 + 1;
            count++;
        }
        return count;
    }
}