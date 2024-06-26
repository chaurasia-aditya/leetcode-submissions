// https://leetcode.com/problems/happy-number

class Solution {
    public boolean isHappy(int n) {
        int temp, cur=n;
        while(cur!=1 && cur!=4){
            temp = cur;
            cur =0;
            while(temp!=0){
                int r = temp%10;
                cur+=r*r;
                temp=temp/10;
            }
        }
        return cur==1;
    }
}