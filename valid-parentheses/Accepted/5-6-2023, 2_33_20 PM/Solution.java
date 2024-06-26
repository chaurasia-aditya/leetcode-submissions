// https://leetcode.com/problems/valid-parentheses

class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            switch(ch){
                case ')':{
                    if(s.isEmpty() || (!s.isEmpty() && s.peek() != '(')){
                        return false;
                    }
                    s.pop();
                    break;
                }
                case '}':{
                    if(s.isEmpty() || (!s.isEmpty() && s.peek() != '{')){
                        return false;
                    }
                    s.pop();
                    break;
                }
                case ']':{
                    if(s.isEmpty() || (!s.isEmpty() && s.peek() != '[')){
                        return false;
                    }
                    s.pop();
                    break;
                }
                default: s.push(ch);
            }
        }
        if(s.isEmpty())
            return true;
        return false;
    }
}