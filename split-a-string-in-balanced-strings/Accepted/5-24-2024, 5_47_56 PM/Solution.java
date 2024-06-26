// https://leetcode.com/problems/split-a-string-in-balanced-strings

class Solution {
    public int balancedStringSplit(String s) {
        int res = 0;
        
        int countR = 0, countL = 0;
        
        for(char ch:s.toCharArray()){
            if(ch == 'R')
                countR++;
            else
                countL++;
            
            if(countR == countL)
                res++;
        }
        
        return res;
    }
}