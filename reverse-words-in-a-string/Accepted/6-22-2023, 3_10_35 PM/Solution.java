// https://leetcode.com/problems/reverse-words-in-a-string

class Solution {
    public String reverseWords(String s) {
        s.trim();
        StringBuilder res = new StringBuilder();
        int start,end;
        for(int i=0;i<s.length();){
            start = end = i;
            while(i<s.length() && s.charAt(i) != ' '){
                i++;
            }
            end = i;
            res.insert(0, s.substring(start, end));
            res.insert(0, " ");
            while(i<s.length() && s.charAt(i)==' ')
                i++;
        }

        return res.toString().trim();
    }
}