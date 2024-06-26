// https://leetcode.com/problems/evaluate-reverse-polish-notation

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st= new Stack<>();
        int res;
        boolean first = true;
        for(String ch: tokens){
            if(!ch.equals("+") && !ch.equals("-") && !ch.equals("*") && !ch.equals("/")){
                st.push(Integer.valueOf(ch));
            }else{
                int b = st.pop();
                int a = st.pop();
                if(ch.equals("+")){
                    res = a+b;
                }else if(ch.equals("-")){
                    res = a-b;
                }else if(ch.equals("*")){
                    res = a*b;
                }else{
                    res = a/b;
                }
                st.push(res);
            }
        }
        return st.pop();
    }
}