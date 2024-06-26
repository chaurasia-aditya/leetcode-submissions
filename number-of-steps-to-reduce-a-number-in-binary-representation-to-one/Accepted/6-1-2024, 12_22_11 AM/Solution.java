// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one

class Solution {
    public int numSteps(String s) {
        int n = s.length();
        int carry = 0;
        int res = 0;
        for(int i=n-1;i>0;i--){
            int cur = (s.charAt(i)-'0')+carry;

            carry = (cur/2);
            cur = cur%2;

            if(cur == 0){
                res++;
            }else{
                res+=2;
                if(carry == 0)
                    carry = 1;
            }
            // System.out.println("cur")
        }

        if(carry==1 && s.charAt(0) == '1')
            res++;

        return res;
    }
}