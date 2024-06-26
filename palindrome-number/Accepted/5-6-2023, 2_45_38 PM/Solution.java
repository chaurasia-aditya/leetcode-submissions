// https://leetcode.com/problems/palindrome-number

class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        String rev = new StringBuilder(s).reverse().toString();

        if(s.compareTo(rev) == 0){
            return true;
        }
        return false;
    }
}