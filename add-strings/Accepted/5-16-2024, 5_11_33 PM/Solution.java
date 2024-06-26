// https://leetcode.com/problems/add-strings

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int n1, n2, sum, carry = 0;
        int i = num1.length()-1;
        int j = num2.length()-1;
        
        while(i>=0 && j>=0){
            n1 = num1.charAt(i)-'0';
            n2 = num2.charAt(j)-'0';
            
            sum = carry+n1+n2;
            res.append(sum%10);
            carry = sum/10;
            i--;
            j--;
        }
        
        while(i>=0){
            n1 = num1.charAt(i)-'0';
            sum = carry+n1;
            res.append(sum%10);
            carry = sum/10;
            i--;
        }
        
        while(j>=0){
            n2 = num2.charAt(j)-'0';
            sum = carry+n2;
            res.append(sum%10);
            carry = sum/10;
            j--;
        }
        
        if(carry!=0){
            res.append(carry);
        }
        
        return res.reverse().toString();
    }
}