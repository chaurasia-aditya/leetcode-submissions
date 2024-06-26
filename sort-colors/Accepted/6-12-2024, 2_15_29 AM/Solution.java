// https://leetcode.com/problems/sort-colors

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return;

        int red = -1, blue = n;

        for(int i=0;i<blue;i++){
            if(nums[i] == 0){
                if(i==red+1)
                    red++;
                else{
                    nums[i] = nums[red+1];
                    nums[red+1] = 0;
                    red++;
                }
            }else if(nums[i] == 2){
                if(i==blue-1)
                    blue--;
                else{
                    nums[i] = nums[blue-1];
                    nums[blue-1] = 2;
                    blue--;
                    i--;
                }
            }
        }
    }
}