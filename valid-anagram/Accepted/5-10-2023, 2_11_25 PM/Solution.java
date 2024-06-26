// https://leetcode.com/problems/valid-anagram

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        
        int[] c = new int[26];

        for(char ch:s.toCharArray()){
            c[ch-'a']++;
        }
        for(char ch:t.toCharArray()){
            c[ch-'a']--;
        }

        for(int i=0;i<26;i++){
            if(c[i]!=0)
                return false;
        }
        return true;
    }
}