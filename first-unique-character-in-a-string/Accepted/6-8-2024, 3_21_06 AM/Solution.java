// https://leetcode.com/problems/first-unique-character-in-a-string

class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        char[] str = s.toCharArray();

        for(char ch:str){
            freq[ch-'a']++;
        }

        for(int i=0;i<s.length();i++){
            if(freq[str[i]-'a']==1)
                return i;
        }

        return -1;
    }
}