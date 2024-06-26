// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one

class Solution {
    public int numSteps(String s) {
        int n = s.length();
        int carry = 0;
        int res = 0;
        for(int i=n-1;i>0;i--){
            int cur = (s.charAt(i)-'0')+carry;

            if(cur == 1){
                res+=2;
                carry = 1;
            }else{
                res++;
            }
        }

        return res+carry;
    }
}