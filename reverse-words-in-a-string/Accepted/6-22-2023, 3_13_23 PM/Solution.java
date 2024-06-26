// https://leetcode.com/problems/reverse-words-in-a-string

class Solution {
    public String reverseWords(String s) {
        s.trim();
        StringBuilder res = new StringBuilder();
        int start,end;
        for(int i=s.length()-1;i>=0;){
            start = end = i;
            while(i>=0 && s.charAt(i) != ' '){
                i--;
            }
            start = i;
            res.append(s.substring(start+1, end+1));
            res.append(" ");
            while(i>=0 && s.charAt(i)==' ')
                i--;
        }

        return res.toString().trim();
    }
}