// https://leetcode.com/problems/implement-queue-using-stacks

class MyQueue {
    Stack<Integer> st;
    int size;
    int first;
    
    public MyQueue() {
        st = new Stack<>();
        size = 0;    
        first = 0;
    }
    
    public void push(int x) {
        st.push(x);
        size++;
        if(size == 1)
            first = x;
    }
    
    public int pop() {
        Stack<Integer> temp = new Stack<>();
        while(st.size()!=1)
            temp.push(st.pop());
        int ret = st.pop();
        if(size != 1)
            first = temp.peek();
        else
            first = 0;
        
        while(!temp.isEmpty()){
            st.push(temp.pop());
        }
        size--;
        return ret;
    }
    
    public int peek() {
        return first;
    }
    
    public boolean empty() {
        return size == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */