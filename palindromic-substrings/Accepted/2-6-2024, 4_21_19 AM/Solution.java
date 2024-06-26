// https://leetcode.com/problems/palindromic-substrings

class Solution {
    public int countSubstrings(String s) {
        int res = 0;

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

            res+=(high-low)/2;

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

            res+= (high-low)/2;
        }
        return res;
    }
}