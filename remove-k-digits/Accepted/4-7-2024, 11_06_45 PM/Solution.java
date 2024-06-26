// https://leetcode.com/problems/remove-k-digits

class Solution {
    public String removeKdigits(String num, int k) {
        if(k==num.length()){
            return "0";
        }
        
        Stack<Character> st = new Stack<>();
        int count = k;

        for(char ch: num.toCharArray()){
            while(!st.isEmpty() && count!=0 && st.peek()>ch){
                st.pop();
                count--;
            }
            st.push(ch);
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        String res = sb.reverse().toString().substring(0, num.length()-k).replaceFirst("^0*", "");
        return (res.length()==0)?"0":res;
    }
}