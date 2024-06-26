// https://leetcode.com/problems/valid-parentheses

class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            if(ch == ')' || ch == '}' || ch == ']'){
                if(s.isEmpty())
                    return false;
            
                char s_top = s.pop();

                if((ch == ')' && s_top != '(') || (ch == '}' && s_top!='{') 
                || (ch == ']' && s_top !='[')){
                    return false;
                }
            }else{
                s.push(ch);
            }
        }
        if(s.isEmpty())
            return true;
        return false;
    }
}