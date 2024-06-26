// https://leetcode.com/problems/two-sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        // for(int i=0;i<n-1;i++){
        //     for(int j=i+1; j<n;j++){
        //         if(nums[i]+nums[j] == target)
        //             return new int[]{i, j};
        //     }
        // }

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            if(hm.containsKey(target-nums[i])){
                return new int[]{hm.get(target-nums[i]), i};
            }
            hm.put(nums[i], i);
        }

        return null;
    }
}