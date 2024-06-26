// https://leetcode.com/problems/count-pairs-that-form-a-complete-day-ii

class Solution {
    public long countCompleteDayPairs(int[] hours) {
        long res = 0;
        Map<Integer, Integer> hs = new HashMap<>();
        
        for (int i=0; i<hours.length; i++) {
            int rem = hours[i]%24;
            int comp = (24-rem)%24;

            if (hs.containsKey(comp)) {
                res += hs.get(comp);
            }

            hs.put(rem, hs.getOrDefault(rem,0)+1);
        }
        
        return res;
    }
}