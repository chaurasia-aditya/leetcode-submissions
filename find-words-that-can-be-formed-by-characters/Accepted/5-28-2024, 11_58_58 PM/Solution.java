// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        
        for(char ch: chars.toCharArray())
            count[ch-'a']++;
        
        int res = 0;
        
        for(String s:words){
            int[] temp = new int[26];
            for(char ch: s.toCharArray())
                temp[ch-'a']++;
            int i = 0;
            for(;i<26;i++){
                if(temp[i]>count[i])
                    break;
            }
            
            if(i==26){
                res+=s.length();
            }
        }
        
        return res;
    }
}