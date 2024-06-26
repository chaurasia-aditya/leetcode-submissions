// https://leetcode.com/problems/find-the-duplicate-number

class Solution {
    public int findDuplicate(int[] nums) {
        // Set<Integer> hs = new HashSet<>();
        // for(int i: nums){
        //     if(hs.contains(i)){
        //         return i;
        //     }
        //     hs.add(i);
        // }
        int in;
        for(int i=0;i<nums.length;i++){
            in = Math.abs(nums[i]);
            nums[in] = -nums[in];
            if(nums[in] > 0){
                return in; 
            }
        }
        return -1;
    }
}