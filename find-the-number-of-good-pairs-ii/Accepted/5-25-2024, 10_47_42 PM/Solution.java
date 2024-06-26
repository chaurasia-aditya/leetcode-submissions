// https://leetcode.com/problems/find-the-number-of-good-pairs-ii

class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        long res = 0;
        int n = nums1.length;
        int m = nums2.length;
        
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        
        for(int i=0;i<m;i++){
            nums2[i]*=k;
            if (!freq.containsKey(nums2[i])) {
                freq.put(nums2[i], 1);
            }
            else {
                freq.put(nums2[i], freq.get(nums2[i]) + 1);
            }
        }
        
 
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= Math.sqrt(nums1[i]); j++) {
                if (nums1[i] % j == 0) {
                    if (nums1[i] == j*j) {
                        res += freq.getOrDefault(j,0);
                    }
                    else {
                        res += freq.getOrDefault(j,0) + freq.getOrDefault((nums1[i] / j), 0);
                    }
                }
            }
        }
        
        return res;
    }
}