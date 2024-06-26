// https://leetcode.com/problems/sort-colors

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int start=0 , end = n-1;
        
        for(int i=0;i<n;){
            if(nums[i] == 0 && i> start){
                int temp = nums[start];
                nums[start++] = 0;
                nums[i] = temp;
            }else if(nums[i] == 2 && i<end){
                int temp = nums[end];
                nums[end--] = 2;
                nums[i] = temp;
            }else{
                i++;
            }
        }
    }
}