// https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three

class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;

        for(int num:nums){
            count+=(num%3==0?0:1);
        }

        return count;
    }
}