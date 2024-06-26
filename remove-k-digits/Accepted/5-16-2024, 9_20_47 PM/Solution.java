// https://leetcode.com/problems/remove-k-digits

class Solution {    
    public String removeKdigits(String num, int k) {
        if(k>=num.length()){
            return "0";
        }

        char[] st = new char[num.length()];
        int i = -1;
        int count = k;

        for(char ch: num.toCharArray()){
            while(i!=-1 && count!=0 && st[i]>ch){
                i--;
                count--;
            }
            i++;
            st[i] = ch;
        }

        String res = (new String(st)).substring(0, num.length()-k).replaceFirst("^0*", "");

        return (res.length()==0)?"0":res;
    }
}