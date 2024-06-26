// https://leetcode.com/problems/valid-palindrome

class Solution {
    public boolean isPalindrome(String s) {
        for(int i=0, j=s.length()-1;i<j;){
            if(Character.isLetterOrDigit(s.charAt(i))){
                if(Character.isLetterOrDigit(s.charAt(j))){
                    if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j)))
                        return false;
                    else{
                        i++;
                        j--;
                    }
                }else{
                    j--;
                }
            }else{
                i++;
            }
        }
        return true;
    }
}