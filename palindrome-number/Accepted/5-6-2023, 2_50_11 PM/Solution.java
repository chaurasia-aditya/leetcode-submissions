// https://leetcode.com/problems/palindrome-number

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false; 

        int rev = 0;
        int cur = x, rem;
        while(cur>0){
            rem = cur%10;
            cur/=10;
            rev= rev*10+rem;
        }

        if(rev == x){
            return true;
        }
        return false;
    }
}