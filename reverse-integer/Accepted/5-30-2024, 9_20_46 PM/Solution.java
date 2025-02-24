// https://leetcode.com/problems/reverse-integer

class Solution {
    public int reverse(int x) {
        int res = 0;
        int rem;

        while(x!=0){
            rem = x%10;
            x/=10;
            if(res>Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && rem>7))
                return 0;
            if(res<Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && rem<-8))
                return 0;
            
            res = res*10+rem;
        }
        
        return res;
    }
}