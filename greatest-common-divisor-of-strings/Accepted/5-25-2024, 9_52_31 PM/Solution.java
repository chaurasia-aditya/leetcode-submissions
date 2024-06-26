// https://leetcode.com/problems/greatest-common-divisor-of-strings

class Solution {
    int gcd(int a, int b){
        if(a == 0)
            return b;
        if(b == 0)
            return a;
        if(a == b)
            return a;
        if(a>b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }
    public String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        
        if(l1 == 0 || l2 == 0)
            return "";
        
        int len = gcd(l1, l2);
        
        String res = "";
        
        for(int i = 0; i<len; i++){
            String cur1 = str1.substring(0, i+1);
            String cur2 = str2.substring(0, i+1);
            
            if(!cur1.equals(cur2) || (l1%(i+1))!=0 || (l2%(i+1))!=0){
                continue;
            }
            
            if(cur1.repeat(l1/(i+1)).equals(str1) && cur2.repeat(l2/(i+1)).equals(str2)){
                res = cur1;
            }
        }
        
        return res;
    }
}