// https://leetcode.com/problems/grumpy-bookstore-owner

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int res = 0;
        int max = 0, cur = 0;
        int n = customers.length;
        
        for(int i=0;i<n;i++){
            if(grumpy[i] == 0)
                res+=customers[i];
            
            if(grumpy[i] == 1){
                cur+=customers[i];
            }
            if(i>=minutes && grumpy[i-minutes] == 1){
                cur-=customers[i-minutes];
            }

            max = Math.max(max, cur);
        }
        return res+max;
    }
}