// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int low, high, cur_len, res = 0;
        for (int n : nums) {
            if (!hm.containsKey(n)) {
                low = hm.getOrDefault(n-1, 0);
                high = hm.getOrDefault(n+1, 0);

                cur_len = low + high + 1;
                hm.put(n, cur_len);
                res = Math.max(res, cur_len);

                hm.put(n - low, cur_len);
                hm.put(n + high, cur_len);
            }
            else {
                continue;
            }
        }
        return res;
    }
}