// https://leetcode.com/problems/find-the-duplicate-number

class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        for(int i =0; i<nums.size();i++){
            int in = abs(nums[i])-1;
            nums[in] = -nums[in];
            if(nums[in]>0){
                return abs(nums[i]);
            }
        }
        return -1;
    }
};