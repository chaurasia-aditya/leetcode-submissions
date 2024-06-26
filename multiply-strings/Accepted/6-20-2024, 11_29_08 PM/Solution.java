// https://leetcode.com/problems/multiply-strings

class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";

        int n1 = num1.length();
        int n2 = num2.length();

        int[] prod = new int[n1+n2-1];
        
        for(int i=0;i<n1;i++){
            for(int j = 0;j<n2;j++){
                prod[i+j]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }

        for(int i=prod.length-1;i>0;i--){
            prod[i-1]+=prod[i]/10;
            prod[i]%=10;
        }

        StringBuilder sb = new StringBuilder();
        for(int n:prod)
            sb.append(n);

        return sb.toString();
    }
}