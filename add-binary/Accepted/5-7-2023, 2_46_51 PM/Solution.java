// https://leetcode.com/problems/add-binary

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int a_len = a.length(), b_len = b.length();
        int i,j, carry = 0, cur;
        for(i=a_len-1, j=b_len-1;i>=0 && j>=0;i--,j--){
            cur = (a.charAt(i)-'0')+(b.charAt(j)-'0')+carry;
            sb.append(cur%2);
            carry = cur/2;
        }
        while(i>=0){
            cur = (a.charAt(i--)-'0')+carry;
            sb.append(cur%2);
            carry = cur/2;
        }
        while(j>=0){
            cur = (b.charAt(j--)-'0')+carry;
            sb.append(cur%2);
            carry = cur/2;
        }
        if(carry!=0){
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}