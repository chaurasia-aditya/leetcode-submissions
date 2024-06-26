// https://leetcode.com/problems/daily-temperatures

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        // Stack<Integer> st = new Stack<>();

        // for(int i=temperatures.length-1;i>=0;i--){
        //     while(!st.isEmpty() && temperatures[st.peek()]<= temperatures[i])
        //         st.pop();
            
        //     if(!st.isEmpty()){
        //         res[i] = st.peek()-i;
        //     }

        //     st.push(i);
        // }

        int[] stack = new int[temperatures.length];
        int top = -1;

        for(int i=temperatures.length-1;i>=0;i--){
            while(top>=0 && temperatures[stack[top]]<= temperatures[i])
                top--;
            
            if(top>=0){
                res[i] = stack[top]-i;
            }

            stack[++top]=i;
        }

        return res;
    }
}