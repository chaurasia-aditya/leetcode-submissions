// https://leetcode.com/problems/isomorphic-strings

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] conv = new int[128];
        boolean[] mapped = new boolean[128];
        Arrays.fill(conv, -1);
        for(int i=0;i<s.length();i++){
            int c1 = (int)s.charAt(i);
            int c2 = (int)t.charAt(i);
/*           
            switch(conv[c1]){
                case -1:{
                    if(conv[c1] ! = c2)
                        return false;
                    break;
                }
                default:{
                    if(mapped[c2] == true)
                        return false;
                    conv[c1] = c2;
                }
            }
*/           
            if(conv[c1] != -1 && conv[c1]!=c2){
                return false;
            }else if(conv[c1]==-1){
                if(mapped[c2] == true)
                    return false;
                conv[c1] = c2;
                mapped[c2] = true;
            }
        }
        return true;
    }
}