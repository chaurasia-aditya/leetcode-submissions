// https://leetcode.com/problems/continuous-subarray-sum

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        hm.put(0, -1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int rem = sum%k;
            if(hm.containsKey(rem)){
                if(hm.get(rem)<i-1)
                    return true;
            }
            else
                hm.put(rem, i);
        }
        return false;
    }
}