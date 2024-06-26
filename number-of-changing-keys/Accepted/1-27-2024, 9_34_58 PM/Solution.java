// https://leetcode.com/problems/number-of-changing-keys

class Solution {
    public int countKeyChanges(String s) {
        int count = 0;
        char ch = s.charAt(0);
        
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            if(c == ch || c+32==ch || c-32 == ch)
                continue;
            else{
                ch = c;
                count++;
            }
        }
        
        return count;
    }
}