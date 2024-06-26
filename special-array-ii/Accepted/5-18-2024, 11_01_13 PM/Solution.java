// https://leetcode.com/problems/special-array-ii

class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int q = queries.length;
        int n = nums.length;
        
        boolean[] res = new boolean[q];
        int[] parity = new int[n];

        for (int i = 1; i < n; i++) {
            parity[i] = parity[i - 1];
            if ((nums[i - 1] % 2) != (nums[i] % 2)) {
                parity[i]++;
            }
        }
        
        
        for(int i=0;i<q;i++){
            int st = queries[i][0];
            int end = queries[i][1];
            
            int specialCount = parity[end] - (st > 0 ? parity[st] : 0);
            boolean isSpecial = specialCount == (end - st);
            res[i] = isSpecial;
        }
        
        return res;
    }
}