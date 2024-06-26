// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        
        int start = 0, len = 1;
        int low, high;

        for(int i=0;i<n;i++){
            low = i-1;
            high = i;

            while(low>=0 && high<n && s.charAt(low) == s.charAt(high)){
                if(high-low+1 > len){
                    start = low;
                    len = high-low+1;
                }
                low--;
                high++;
            }

            low = i-1;
            high = i+1;

            while(low>=0 && high<n && s.charAt(low) == s.charAt(high)){
                if(high-low+1 > len){
                    start = low;
                    len = high-low+1;
                }
                low--;
                high++;
            }
        }
        return s.substring(start, start+len);
    }
}