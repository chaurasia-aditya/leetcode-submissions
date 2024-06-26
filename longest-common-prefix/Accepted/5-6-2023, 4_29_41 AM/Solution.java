// https://leetcode.com/problems/longest-common-prefix

class Solution {
    public String longestCommonPrefix(String[] strs) {
        for(int i=0;i<strs[0].length();i++){
            char ch = strs[0].charAt(i);
            for(String s:strs){
                if(s.length()<=i || s.charAt(i)!=ch)
                    return s.substring(0, i);
            }
        }
        return strs[0];
    }
}