// https://leetcode.com/problems/valid-parentheses

class Solution {
    public boolean isValid(String st) {
        Stack<Character> s = new Stack<>();
        for(char ch:st.toCharArray()){
            switch(ch){
                case '(':
                case '{':
                case '[':{
                    s.push(ch);
                    break;
                }
                case ')':
                case '}':
                case ']':{
                    if(s.isEmpty())
                        return false;
                    char t = s.pop();
                    if((ch == ')' && t!='(') || (ch == '}' && t!='{') || (ch == ']' && t!='[')){
                        return false;
                    }
                    break;
                }
            }
        }
        return s.isEmpty();
    }
}