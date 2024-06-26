// https://leetcode.com/problems/next-permutation

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int bp = -1;
        
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                bp=i;
                break;
            }
        }
        
        if(bp == -1)
            reverse(nums, 0);
        else{
            int min = -1;

            for(int i = n-1; i>=0 ; i--){
                if(nums[i]>nums[bp]){
                    min = i;
                    break;
                }
            }

            swap(nums, bp, min);
            reverse(nums, bp+1);
        }
    }

    void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    void reverse(int[] nums,int start){
        int i=start;
        int j=nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}