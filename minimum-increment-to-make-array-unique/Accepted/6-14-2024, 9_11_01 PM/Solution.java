// https://leetcode.com/problems/minimum-increment-to-make-array-unique

class Solution {
    public int minIncrementForUnique(int[] nums) {
        if(nums.length == 1)
            return 0;

        int count = 0;
        Arrays.sort(nums);

        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1])
                continue;
            else{
                count+=(nums[i-1]+1-nums[i]);
                nums[i] = nums[i-1]+1;
            }
        }

        return count;
    }
}