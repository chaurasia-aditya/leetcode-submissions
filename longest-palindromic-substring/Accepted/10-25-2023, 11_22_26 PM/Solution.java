// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int low, high;
        int max = 0;
        String res = "";// = s.substring(0,1);
        for(int i=0;i<n;i++){
            low =i;
            high = i;
            while(low>=0 && high<n && s.charAt(low) == s.charAt(high)){
                low--;
                high++;
            }
            if(high-low+1>max){
                max = high-low+1;
                res = s.substring(low+1, high);
            }
            low = i;
            high = i+1;
            while(low>=0 && high<n && s.charAt(low) == s.charAt(high)){
                low--;
                high++;
            }
            if(high-low+1>max){
                max = high-low+1;
                res = s.substring(low+1, high);
            }
        }
        return res;
    }
}