// https://leetcode.com/problems/longest-increasing-subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {
        // int[] lis = new int[nums.length];
        // lis[0] = 1;
        // int max = 1;
        // for(int i=1;i<nums.length;i++){
        //     lis[i] = 1;
        //     for(int j=0;j<i;j++){
        //         if(nums[i] > nums[j] && lis[i]<lis[j]+1){
        //             lis[i] = lis[j]+1;
        //         }
        //     }
        //     max = Math.max(max, lis[i]);
        // }
        // return max;

        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int idx;
        res.add(nums[0]);
 
        for (int i = 1; i < n; i++) {
            if (nums[i] > res.get(res.size() - 1)) {
                res.add(nums[i]);
            } else {
                idx = Collections.binarySearch(res, nums[i]);
                if (idx < 0) {
                    idx = -(idx + 1);
                }
                res.set(idx, nums[i]);
            }
        }
        return res.size();
    }
}