// https://leetcode.com/problems/sort-an-array

class Solution {
    int MAX = 100001;
    public int[] sortArray(int[] nums) {
        int[] count = new int[MAX];
        
        for(int i=0;i<nums.length;i++)
            count[nums[i]+50000]++;
        int j = 0;
        for(int i=0;i<MAX;i++){
            while(count[i]-- > 0){
                nums[j] = i-50000;
                j++;
            }
        }

        return nums;
    }
}