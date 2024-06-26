// https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room

class Solution {
    public int minimumChairs(String s) {
        int cur = 0, max = 0;
        
        for(char ch: s.toCharArray()){
            if(ch == 'E'){
                cur++;
                max = Math.max(max, cur);
            }
            else{
                cur--;
            }
        }
        
        return max;
    }
}