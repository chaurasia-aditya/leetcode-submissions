// https://leetcode.com/problems/remove-element

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, l = nums.length;
        while (i < l) {
            if (nums[i] == val) {
                nums[i] = nums[l - 1];
                l--;
            } else {
                i++;
            }
        }
        return l;
    }
}