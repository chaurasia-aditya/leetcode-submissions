// https://leetcode.com/problems/valid-anagram

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        // int[] alpha = new int[26];
        // int wrong = 0;
        // for(int i=0;i<s.length();i++){
        //     alpha[s.charAt(i)-'a']++;
        //     alpha[t.charAt(i)-'a']--;
        // }
        // for(int i=0;i<26;i++){
        //     if(alpha[i]!=0)
        //         return false;
        // }
        char[] s1 = s.toCharArray();
        char[] t1  = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1,t1);
        //return true;
    }
}