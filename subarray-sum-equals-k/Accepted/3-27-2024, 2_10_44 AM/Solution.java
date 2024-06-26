// https://leetcode.com/problems/subarray-sum-equals-k

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int cur = 0;
        Map<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);

        for(int i=0;i<nums.length;i++){
            cur += nums[i];
            if(hm.containsKey(cur-k)){
                count += hm.get(cur-k);
            }
            hm.put(cur, hm.getOrDefault(cur,0)+1);
        }
        return count;
    }
}