// https://leetcode.com/problems/happy-number

class Solution {
    public boolean isHappy(int n) {
        ArrayList<Integer> hs = new ArrayList<>();
        int curSum = 0;
        hs.add(n);
        while(true){
            if(n==1)
                return true;
            while(n>0){
                curSum+=Math.pow(n%10,2);
                n/=10;
            }
            n = curSum;
            curSum = 0;
            if(hs.contains(n))
                return false;
            else
                hs.add(n);
        }
    }
}