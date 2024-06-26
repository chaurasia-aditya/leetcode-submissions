// https://leetcode.com/problems/palindrome-number

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        long temp = x;
        long rev = 0;
        
        while(temp>0){
            rev*=10;
            rev+=(temp%10);
            temp/=10;
        }
        return rev==x;
    }
}