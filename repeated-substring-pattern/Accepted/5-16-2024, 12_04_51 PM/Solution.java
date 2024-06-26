// https://leetcode.com/problems/repeated-substring-pattern

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if(n == 1)
            return false;
        int i = 1;
        for(;i<n/2;i++){
            int len = i+1;
            if((n%len) != 0)
                continue;
            String substr = s.substring(0, i+1);
            int j;
            for(j=i+1;j<n;j++){
                if(substr.charAt(j%len)!=s.charAt(j))
                    break;
            }
            
            if(j == n)
                return true;
        }
        char ch = s.charAt(0);
        i = 1;
        for(;i<n;i++){
            if(s.charAt(i)!=ch)
                break;
        }
        
        return i==n;
    }
}