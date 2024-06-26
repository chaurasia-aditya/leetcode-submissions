// https://leetcode.com/problems/patching-array

class Solution {
    public int minPatches(int[] nums, int n) {
        // int miss = 1;
        // int res = 0;
        // int i = 0;

        // while(miss<=n){
        //     if(i<nums.length && nums[i]<=miss){
        //         miss+=nums[i];
        //         i++;
        //     } else{
        //         miss+=miss;
        //         res++;
        //     }
        // }

        // return res;


        int ans = 0;
        long sum = 0;
        for (int i = 0; i < nums.length && sum < n; i++) {
            if (nums[i] <= sum + 1) {
                sum += nums[i];
            } else {
                i--;
                ans++;
                sum = sum * 2 + 1;
            }
        }
        while (sum < n) {
            sum = sum * 2 + 1;
            ans++;
        }
        return ans;
    }
}