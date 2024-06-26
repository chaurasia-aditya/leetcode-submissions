// https://leetcode.com/problems/longest-increasing-subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int idx, size = 1;
        res.add(nums[0]);
 
        for (int i = 1; i < n; i++) {
            if (nums[i] > res.get(size - 1)) {
                res.add(nums[i]);
                size++;
            } else {
                idx = Collections.binarySearch(res, nums[i]);
                if (idx < 0) {
                    idx = -(idx + 1);
                }
                res.set(idx, nums[i]);
            }
        }
        return size;
    }
}