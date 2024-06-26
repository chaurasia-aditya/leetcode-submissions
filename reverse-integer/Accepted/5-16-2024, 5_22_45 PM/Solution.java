// https://leetcode.com/problems/reverse-integer

class Solution {
    public int reverse(int x) {
        int res = 0;
        boolean neg = (x<0);
        int temp = Math.abs(x);
        
        while(temp>0){
            if(((long)res*10)>Integer.MAX_VALUE)
                return 0;
            res = (res*10)+(temp%10);
            temp/=10;
        }
        
        if(neg)
            res*=-1;
        
        if(neg && res>0)
            return 0;
        return res;
    }
}