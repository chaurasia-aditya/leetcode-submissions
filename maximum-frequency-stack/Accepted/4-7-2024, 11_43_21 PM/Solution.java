// https://leetcode.com/problems/maximum-frequency-stack

class FreqStack {
    Map<Integer, Stack<Integer>> st;
    Map<Integer, Integer> freq;
    int max;

    public FreqStack() {
        st = new HashMap<>();
        freq = new HashMap<>();
        max = 0;    
    }
    
    public void push(int val) {
        int count = freq.getOrDefault(val, 0)+1;
        max = Math.max(count, max);

        freq.put(val, count);
        st.putIfAbsent(count, new Stack<>());
        st.get(count).push(val);
    }
    
    public int pop() {
        Stack<Integer> maxFreq = st.get(max);
        int res = maxFreq.pop();

        if(maxFreq.isEmpty()){
            // st.remove(max);
            max--;
        }

        freq.put(res, freq.get(res)-1);

        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */