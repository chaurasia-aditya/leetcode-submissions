// https://leetcode.com/problems/minimum-number-game

class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        for(int i=0;i<nums.length;i+=2){
            arr[i+1] = nums[i];
            arr[i] = nums[i+1];
        }
        return arr;
    }
}