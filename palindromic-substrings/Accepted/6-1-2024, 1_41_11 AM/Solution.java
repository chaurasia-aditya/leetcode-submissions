// https://leetcode.com/problems/palindromic-substrings

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            int j = 0;
            while(i-j>=0 && i+j<n && s.charAt(i-j) == s.charAt(i+j)){
                count++;
                j++;
            }

            j=i;
            int k =i+1; 
            while(j>=0 && k<n && s.charAt(k) == s.charAt(j)){
                count++;
                j--;
                k++;
            }
        }

        return count;
    }
}