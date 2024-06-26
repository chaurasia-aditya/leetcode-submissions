// https://leetcode.com/problems/repeated-substring-pattern

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if(n==1)
            return false;
        
        for(int len=n/2;len>0;len--){
            
            if((n%len) == 0 && s.charAt(len-1) == s.charAt(n-1)){
                int count = n/len;
                
                String substr = s.substring(0, len);
                if(substr.repeat(count).equals(s))
                    return true;
            }
        }
        
        return false;
    }
}