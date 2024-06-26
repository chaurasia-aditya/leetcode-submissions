// https://leetcode.com/problems/rotate-array

class Solution {

    void reverse(int[] nums, int i, int j){
        while(i<j){
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }

    public void rotate(int[] nums, int k) {
        if(k==0)
            return;
        int n = nums.length;
        k = k%n;
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-k-1);
        reverse(nums, 0, n-1);
    }
}