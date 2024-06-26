// https://leetcode.com/problems/count-alternating-subarrays

class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long res = 0;
        
        int i=0, j=0;
        
        while(i<nums.length && j<nums.length){
            if(j<nums.length-1 && nums[j+1]!=nums[j]){
                j++;
            }else{
                res += (((long)(j-i+2)*(j-i+1))/2);
                i=j+1;
                j=i;
            }
        }
        
        return res;
    }
}