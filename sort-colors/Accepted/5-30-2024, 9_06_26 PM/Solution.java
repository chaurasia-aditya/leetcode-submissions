// https://leetcode.com/problems/sort-colors

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int last_0 = -1, last_2 = n;
        
        for(int i=0;i<last_2;i++){
            if(nums[i] == 0 && last_0!=i){
                int temp = nums[++last_0];
                nums[last_0] = 0;
                nums[i] = temp;
                i--;
            }else if(nums[i] == 2){
                int temp = nums[--last_2];
                nums[last_2] = 2;
                nums[i] = temp;
                i--;
            }
        }
    }
}