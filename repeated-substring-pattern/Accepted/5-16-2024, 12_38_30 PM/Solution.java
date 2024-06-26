// https://leetcode.com/problems/repeated-substring-pattern

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if(n == 1)
            return false;
        int i = 0;
        for(;i<n/2;i++){
            int len = i+1;
            if((n%len) != 0)
                continue;
            int count = n/len;
            String substr = s.substring(0, i+1);
            if(substr.repeat(count).equals(s))
                return true;
        }
        
        return false;
    }
}