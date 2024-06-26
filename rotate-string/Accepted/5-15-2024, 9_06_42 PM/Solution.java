// https://leetcode.com/problems/rotate-string

class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())
            return false;
        
        String concat = new String(s+s);
        
        if(concat.indexOf(goal)!=-1)
            return true;
        return false;
    }
}