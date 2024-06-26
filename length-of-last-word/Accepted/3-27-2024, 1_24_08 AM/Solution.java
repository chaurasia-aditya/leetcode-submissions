// https://leetcode.com/problems/length-of-last-word

class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        char[] str = s.toCharArray();
        int i = str.length-1, st=-1;        

        while(i>=0 && str[i] == ' ')
            i--;
        
        if(i == -1)
            return 0;
        
        st = i;
        i--;
        while(i>=0 && str[i]!=' '){
            i--;
        }

        return st-i;
    }
}