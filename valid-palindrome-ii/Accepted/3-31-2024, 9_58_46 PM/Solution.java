// https://leetcode.com/problems/valid-palindrome-ii

class Solution {
    boolean check(String s, int i, int j, int count){
        if(count>1){
            return false;
        }

        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return check(s, i+1, j, count+1)|check(s, i, j-1, count+1);
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int i=0, j=s.length()-1;

        return check(s, 0, s.length()-1, 0);
    }
}