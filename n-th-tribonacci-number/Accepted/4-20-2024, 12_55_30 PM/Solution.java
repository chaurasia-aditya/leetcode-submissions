// https://leetcode.com/problems/n-th-tribonacci-number

class Solution {
    public int tribonacci(int n) {
        if(n==0){
            return 0;
        }else if(n==1 || n==2){
            return 1;
        }
        
        int a = 0, b = 1, c = 1;

        for(int i=0;i<n-2;i++){
            int temp = a+b+c;
            a=b;
            b=c;
            c=temp;
        }

        return c;
    }
}