// https://leetcode.com/problems/fruit-into-baskets

class Solution {
    public int totalFruit(int[] fruits) {
        int f=-1, s=-1;
        int cur = 0, max = 0;
        int lcount = 0;

        for(int fruit:fruits){
            if(fruit == f || fruit == s){
                cur++;
            }else{
                max = Math.max(max, cur);
                cur = lcount+1;
            }

            if(fruit == f){
                lcount++;
            }else{
                s = f;
                f = fruit;
                lcount = 1; 
            }
        }

        return Math.max(cur, max);
    }
}