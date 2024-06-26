// https://leetcode.com/problems/shuffle-string

class Solution {
    public String restoreString(String s, int[] indices) {
        int n = s.length();
        char[] str = s.toCharArray();

        char[] res = new char[n];
        
        for(int i=0;i<n;i++){
            res[indices[i]] = str[i];
        }
        
        return new String(res);
    }
}