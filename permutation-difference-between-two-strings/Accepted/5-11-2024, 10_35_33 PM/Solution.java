// https://leetcode.com/problems/permutation-difference-between-two-strings

class Solution {
    public int findPermutationDifference(String s, String t) {
        int[] map = new int[26];
        // Arrays.fill(map, -1);
        int res = 0;
        
        for(int i=0;i<s.length();i++){
            map[s.charAt(i)-'a'] = i;
        }
        
        for(int i=0;i<s.length();i++){
            res+= Math.abs(i-map[t.charAt(i)-'a']);
        }
        
        return res;
    }
}