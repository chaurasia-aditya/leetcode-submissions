// https://leetcode.com/problems/contains-duplicate-ii

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int i=0;
        for(int n:nums){
            if(hm.containsKey(n) && (i - hm.get(n))<=k){
                return true;
            }
            hm.put(n, i);
            i++;
        }
        return false;
    }
}