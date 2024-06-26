// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array

class Solution {
public:
    int findMin(vector<int>& nums) {
        int low = 0, high = nums.size()-1;
        if(nums[low]<=nums[high]){
            return nums[low];
        }
        while(low<=high){
            int mid = low + (high-low) / 2;

            if (mid-1 >= 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
};