// https://leetcode.com/problems/word-pattern

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sArr = s.split(" ");
        
        String[] stored = new String[26];
        
        if(pattern.length()!=sArr.length)
            return false;
        
        for(int i=0;i<sArr.length;i++){
            int val = pattern.charAt(i)-'a';
            String st = stored[val];
            if(st == null){
                for(String cur:stored){
                    if(cur!=null && cur.compareTo(sArr[i])==0){
                        return false;
                    }
                }
                stored[val] = sArr[i];
            }
            else if(st.compareTo(sArr[i])!=0){
                return false;
            }
        }
        
        return true;
    }
}