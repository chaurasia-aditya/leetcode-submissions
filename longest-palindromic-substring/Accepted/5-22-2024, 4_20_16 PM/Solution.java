// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        
        int st = 0;
        int end = 0;
        int max = 1;
        
        int low, high;
        
        for(int i=0;i<n;i++){
            low = i-1;
            high = i;
            
            
            while(low>=0 && high<n && s.charAt(low) == s.charAt(high)){
                if (high - low + 1 > max) {
                    st = low;
                    end = high; 
                    max = high - low + 1;
                }
                low--;
                high++;
            }
                        
            low = i-1;
            high = i+1;
            
            
            
            while(low>=0 && high<n && s.charAt(low) == s.charAt(high)){
                if (high - low + 1 > max) {
                    st = low;
                    end = high;
                    max = high - low + 1;
                }
                low--;
                high++;
            }
        }
        return s.substring(st, end+1);
    }
}