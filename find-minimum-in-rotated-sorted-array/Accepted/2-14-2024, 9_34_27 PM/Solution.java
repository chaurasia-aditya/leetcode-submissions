// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array

class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        int ans = nums[high];

        while(low<=high){
            int mid = (low+high)>>>1;
            if(nums[mid]>nums[high]){
                low = mid+1;
            }else{
                ans = Math.min(ans, nums[mid]);
                high = mid-1;
            }
        }
        return ans;
    }
}