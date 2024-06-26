// https://leetcode.com/problems/generate-parentheses

class Solution {
    public void generate(List<String> res, StringBuilder s, int n, int cur_open, int cur_close){
        if(cur_open == n && cur_open == cur_close){
            res.add(s.toString());
            return;
        }

        if(cur_open<n){
            s.append('(');
            generate(res, s, n, cur_open+1, cur_close);
            s.deleteCharAt(s.length()-1);
        }
        if(cur_close<cur_open){
            s.append(')');
            generate(res, s, n, cur_open, cur_close+1);
            s.deleteCharAt(s.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        generate(res, new StringBuilder("("), n, 1, 0);

        return res;
    }
}