// https://leetcode.com/problems/regular-expression-matching

class Solution {
    Map<String, Boolean> memo = new HashMap<>();
    boolean backtrack(int pos_s, int pos_p, int n, int m, String s, String p){

        String cur = pos_s+","+pos_p;

        if (memo.containsKey(cur)) {
            return memo.get(cur);
        }

        if(pos_s == n && pos_p == m){
            memo.put(cur, true);
            return true;
        }
        
        if(pos_p == m){
            memo.put(cur, false);
            return false;
        }

        char c = p.charAt(pos_p);

        boolean hasStar = false;
        if(pos_p<m-1 && p.charAt(pos_p+1) == '*')
            hasStar = true;
        
        boolean result = false;

        if(hasStar){
            if(backtrack(pos_s, pos_p+2, n, m, s, p))
                return true;

            for(int i=0;pos_s+i<n;i++){
                if(c == '.'|| s.charAt(pos_s+i)==c){
                    if(backtrack(pos_s+i+1, pos_p, n, m, s, p))
                        result = true;
                        break;
                }else{
                    break;
                }
            }
        }else{
            if(pos_s<n && (c == '.' || c == s.charAt(pos_s))){
                return backtrack(pos_s+1, pos_p+1, n, m, s, p);
            }
        }

        memo.put(cur, result);
        return result;

    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        return backtrack(0, 0, n, m, s, p);
    }
}