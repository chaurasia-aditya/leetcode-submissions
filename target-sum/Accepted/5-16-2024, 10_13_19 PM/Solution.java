// https://leetcode.com/problems/target-sum

class Solution {
    int count = 0;
    void backtrack(int cur, int target, int index, int n, int[] nums){
        if(index == n){
            if(cur == target){
                count++;
            }
            return;
        }

        backtrack(cur+nums[index], target, index+1, n, nums);
        backtrack(cur-nums[index], target, index+1, n, nums);
    }
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(0, target, 0, nums.length, nums);
        return count;   
    }
}