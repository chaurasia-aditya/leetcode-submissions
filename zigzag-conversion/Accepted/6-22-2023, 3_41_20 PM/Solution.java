// https://leetcode.com/problems/zigzag-conversion

class Solution {
    public String convert(String s, int n) {
        int diff = 2*n-2;
        int len = s.length();
        if(len < 3 || n == 1){
            return s;
        }
        StringBuilder res = new StringBuilder();
        for(int i=0;i<n;i++){
            int start = i;
            while(start<len){
                res.append(s.charAt(start));
                start+=diff;
                if(i!=0 && i!=n-1 && start-2*i<len){
                    res.append(s.charAt(start-2*i));
                }
            }
        }
        return res.toString();
    }
}