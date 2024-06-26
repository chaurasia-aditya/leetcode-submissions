// https://leetcode.com/problems/repeated-substring-pattern

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if(n == 1)
            return false;
        for(int i = n/2;i>0;i--){
            int len = i;
            if((n%len) == 0){
                int count = n/len;
                String substr = s.substring(0, i);
                if(substr.repeat(count).equals(s))
                    return true;
            }
        }
        
        return false;
    }
}