// https://leetcode.com/problems/palindrome-number

class Solution {
    public boolean isPalindrome(int x) {
        String n = Integer.toString(x);
        int l = n.length();
        for(int i=0;i<l/2;i++)
        {
            if(n.charAt(i) != n.charAt(l-1-i))
                return false;
        }
        return true;
    }
}