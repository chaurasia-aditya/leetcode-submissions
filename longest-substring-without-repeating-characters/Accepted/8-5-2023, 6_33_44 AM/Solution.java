// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<2){
            return s.length();
        }
        int i, j, val, max = 1;
        HashMap<Character, Integer> found = new HashMap<>();
        for(i=0,j=0;i<s.length() && j<s.length();){
            if(found.containsKey(s.charAt(j))){
                val = found.get(s.charAt(j));
                max = Math.max(max, j-i);
                while(i<=val){
                    found.remove(s.charAt(i));
                    i++;
                }
                continue;
            }
            found.put(s.charAt(j), j);
            j++;
        }
        return max>(j-i)?max:j-i;
    }
}