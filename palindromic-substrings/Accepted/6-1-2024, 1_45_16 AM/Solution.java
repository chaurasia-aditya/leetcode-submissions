// https://leetcode.com/problems/palindromic-substrings

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        int low, high;
        for(int i=0;i<n;i++){
            count++;
            low = i-1;
            high = i+1;
            while(low>=0 && high<n && s.charAt(low) == s.charAt(high)){
                count++;
                high++;
                low--;
            }

            low = i;
            high = i+1;
            while(low>=0 && high<n && s.charAt(low) == s.charAt(high)){
                count++;
                low--;
                high++;
            }
        }

        return count;
    }
}