// https://leetcode.com/problems/valid-palindrome-ii

class Solution {
    boolean check(String s, int i, int j, boolean deleted){
        if(i>=j){
            return true;
        }

        if(s.charAt(i) == s.charAt(j)){
            return check(s, i+1, j-1, deleted);
        }else if(deleted == true){
            return false;
        }else{
            return check(s, i+1, j, true)|check(s, i, j-1, true);
        }
    }
    public boolean validPalindrome(String s) {
        return check(s, 0, s.length()-1, false);
    }
}