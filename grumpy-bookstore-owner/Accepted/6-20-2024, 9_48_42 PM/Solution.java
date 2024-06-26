// https://leetcode.com/problems/grumpy-bookstore-owner

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int res = 0;
        int max = 0, cur = 0;
        int n = customers.length;
        
        for(int i=0;i<n;i++){
            if(grumpy[i] == 0)
                res+=customers[i];
            if(i<minutes){
                max+=grumpy[i]*customers[i];
                cur = max;
            }else{
                cur-=grumpy[i-minutes]*customers[i-minutes];
                cur+=grumpy[i]*customers[i];
                // System.out.println("cur = "+cur+" max = "+max);
                if(cur>max)
                    max = cur;
            }
        }
        // System.out.println("res = "+res);
        return res+max;
    }
}