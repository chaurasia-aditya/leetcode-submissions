// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        // HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        // int low, high, cur_len, res = 0;
        // for (int n : nums) {
        //     if (!hm.containsKey(n)) {
        //         low = hm.getOrDefault(n-1, 0);
        //         high = hm.getOrDefault(n+1, 0);

        //         cur_len = low + high + 1;
        //         hm.put(n, cur_len);
        //         res = Math.max(res, cur_len);

        //         hm.put(n - low, cur_len);
        //         hm.put(n + high, cur_len);
        //     }
        //     else {
        //         continue;
        //     }
        // }
        if(nums.length == 0)
            return 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int cur = 0, res = 0;
        if (nums.length < 1000) {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    if (nums[i] == nums[i-1]+1) {
                        cur++;
                    } else {
                        res = Math.max(res, cur+1);
                        cur = 0;
                    }
                }
            }
            res = Math.max(res, cur+1);
            return res;
        }
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        boolean[] exists = new boolean[max + 1 - min];
        for (int num : nums) {
            exists[num - min] = true;
        }
        for (boolean i : exists) {
            if (i) {
                cur++;
                res = Math.max(res, cur);
            } else {
                cur = 0;
            }
        }
        return res;
    }
}