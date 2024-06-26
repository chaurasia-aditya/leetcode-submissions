// https://leetcode.com/problems/find-polygon-with-the-largest-perimeter

class Solution {
    public long largestPerimeter(int[] nums) {
        long total=0;
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        int i;
        for(i=nums.length-1;i>=2;i--){
            total-=nums[i];
            if(total>nums[i]){
                return total+nums[i];
            }
        }
        return -1;
    }
}