// https://leetcode.com/problems/generate-parentheses

class Solution {
    void generate(int open, int close, int n, StringBuilder sb, List<String> res){
        if(open == n && close == n){
            res.add(sb.toString());
            return;
        }
        
        if(open<n){
            sb.append("(");
            generate(open+1, close, n, sb, res);
            sb.deleteCharAt(open+close);
        }
        if(close<open){
            sb.append(")");
            generate(open, close+1, n, sb, res);
            sb.deleteCharAt(open+close);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        
        generate(0, 0, n, new StringBuilder(), res);
        return res;
    }
}