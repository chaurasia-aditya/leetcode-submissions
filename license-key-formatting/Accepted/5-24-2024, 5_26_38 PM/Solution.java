// https://leetcode.com/problems/license-key-formatting

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder res = new StringBuilder();
        
        int n = s.length();
        int j=0;
        
        for(int i=n-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch == '-')
                continue;
            if(j == 0 && res.length()!=0){
                res.append('-');
            }
            res.append(Character.toUpperCase(ch));
            j = (j+1)%k;
        }
        
        return res.reverse().toString();
    }
}