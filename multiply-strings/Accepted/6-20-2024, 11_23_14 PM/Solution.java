// https://leetcode.com/problems/multiply-strings

class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder("0");

        int n1 = num1.length();
        int n2 = num2.length();
        int cur, carry, res, len, num;

        for(int i=0;i<n2;i++){
            cur = num2.charAt(n2-1-i)-'0';
            carry = 0;
            res = 0;

            len = sb.length();
            for(int j=0;j<n1;j++){
                if(i>0 && len>i+j){
                    carry += sb.charAt(i+j)-'0';
                }
                num = num1.charAt(n1-1-j)-'0';
                res = num*cur+carry;
                if(i+j<len)
                    sb.setCharAt(i+j, (char)('0'+res%10));
                else
                    sb.append((char)('0'+res%10));
                carry = res/10;
            }
            if(carry!=0)
                sb.append(carry);
        }

        return sb.reverse().toString();
    }
}