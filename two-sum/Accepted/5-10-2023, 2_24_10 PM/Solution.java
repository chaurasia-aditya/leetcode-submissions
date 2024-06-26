// https://leetcode.com/problems/two-sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int val;
        for(int i=0;i<nums.length;i++){
            val = nums[i];
            if(hm.containsKey(target - val)){
                return new int[]{hm.get(target-val), i};
            }
            else{
                hm.put(val,i);
            }
        }
        return null;
    }
}