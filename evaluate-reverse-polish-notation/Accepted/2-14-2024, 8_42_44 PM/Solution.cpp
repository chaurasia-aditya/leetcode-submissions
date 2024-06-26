// https://leetcode.com/problems/evaluate-reverse-polish-notation

class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> st;

        for(string& s: tokens){
            if(s == "+" || s=="-" || s=="*" || s=="/"){
                if(st.size()<2)
                    continue;
                int b = st.top();
                st.pop();
                int a = st.top();
                st.pop();

                switch(s[0]){
                    case '+': st.push(a+b);
                        break;
                    case '-': st.push(a-b);
                        break;
                    case '/': st.push(a/b);
                        break;
                    case '*': st.push(a*b);
                        break;
                }
            }else{
                st.push(stoi(s));
            }
        }
        return st.top();
    }
};