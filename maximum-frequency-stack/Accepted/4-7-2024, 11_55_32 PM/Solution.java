// https://leetcode.com/problems/maximum-frequency-stack

class FreqStack {
    ArrayList<ArrayList<Integer>> freqList = null;
    Map<Integer, Integer> freq = null;
    int max;

    public FreqStack() {
        freqList = new ArrayList<>();
        freqList.add(new ArrayList<>());
        freq = new HashMap<>();
        max = 0;    
    }
    
    public void push(int val) {
        int count = freq.getOrDefault(val, 0)+1;
        max = Math.max(count, max);

        freq.put(val, count);

        if(freqList.size()<=count)
            freqList.add(new ArrayList<>());
        freqList.get(count).add(val);
    }
    
    public int pop() {
        ArrayList<Integer> maxFreq = freqList.get(max);
        int res = maxFreq.remove(maxFreq.size()-1);

        if(maxFreq.isEmpty()){
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