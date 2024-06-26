// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        for(int i:nums)
            nums[Math.abs(i)-1] = -Math.abs(nums[Math.abs(i)-1]);
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                res.add(i+1);
        }
        
        return res;
    }
}