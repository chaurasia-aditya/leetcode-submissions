// https://leetcode.com/problems/reverse-words-in-a-string

class Solution {
    public String reverseWords(String s) {
        s.trim();
        StringBuilder cur= new StringBuilder();
        StringBuilder res = new StringBuilder();

        for(int i=0;i<s.length();){
            cur.setLength(0);
            while(i<s.length() && s.charAt(i) != ' '){
                cur.append(s.charAt(i));
                i++;
            }
            cur.append(' ');
            res.insert(0, cur);
            while(i<s.length() && s.charAt(i)==' ')
                i++;
        }

        return res.toString().trim();
    }
}