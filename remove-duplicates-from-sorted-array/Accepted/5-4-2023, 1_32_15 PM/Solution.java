// https://leetcode.com/problems/remove-duplicates-from-sorted-array

class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0, temp;
        for(int j=0;j<nums.length;){
            if(nums[j]==nums[i])
                j++;
            else
            {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}