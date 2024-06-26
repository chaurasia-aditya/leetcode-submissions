// https://leetcode.com/problems/remove-k-digits

class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(k>=n)
            return "0";
        
        char[] str = new char[n];
        int i = -1;
        int remaining = k;        
        
        for(char ch: num.toCharArray()){
            while(i!=-1 && remaining!=0 && str[i]>ch){
                i--;
                remaining--;
            }
            i++;
            str[i] = ch;
        }

        String res = (new String(str)).substring(0, num.length()-k).replaceFirst("^0*", "");

        return (res.length()==0)?"0":res;
        
    }
}