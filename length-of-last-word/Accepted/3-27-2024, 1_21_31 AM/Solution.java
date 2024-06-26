// https://leetcode.com/problems/length-of-last-word

class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int i=0, st=-1;

        char[] str = s.toCharArray();

        while(i<str.length && str[i] == ' ')
            i++;
        
        if(i == str.length)
            return 0;
        
        st = i;
        i++;
        while(i<str.length){
            if(str[i] == ' '){
                len = i-st;
                while(i<str.length && str[i] == ' ')
                    i++;
                if(i==str.length)
                    return len;
                st = i;
            }
            i++;
        }
        if(str[str.length-1]!=' ')
            len = str.length-st;

        return len;
    }
}