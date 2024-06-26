// https://leetcode.com/problems/longest-repeating-character-replacement

class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int cur_max = 0, i = 0, res = 0;
        for(int j=0; j<s.length(); j++){
            count[s.charAt(j) - 'A']++;
            cur_max = Math.max(cur_max, count[s.charAt(j) - 'A']);
            while(j-i+1-cur_max > k){
                count[s.charAt(i) - 'A']--;
                i++;
            }
            res = Math.max(res, j-i+1);
        }
        return res;

    }
}