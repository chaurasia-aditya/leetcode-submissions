// https://leetcode.com/problems/remove-outermost-parentheses

class Solution {
    public String removeOuterParentheses(String s) {
        int open = 0, st = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            switch(ch){
                case '(':{
                    if(open == 0){
                        st = i;
                    }
                    open++;
                    break;
                }
                case ')':{
                    open--;
                    if(open == 0){
                        sb.append(s.substring(st+1, i));
                        st = 0;
                    }
                    break;
                }
            }
        }
        
        return sb.toString();
    }
}