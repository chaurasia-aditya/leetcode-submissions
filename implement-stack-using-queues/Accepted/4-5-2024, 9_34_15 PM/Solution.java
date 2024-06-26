// https://leetcode.com/problems/implement-stack-using-queues

class MyStack {
    Queue<Integer> f, s;
    int top, size;
    boolean second;
    public MyStack() {
        f = new LinkedList<>();
        s = new LinkedList<>();
        top = -1;
        size = 0;
    }
    
    public void push(int x) {
        f.offer(x);
        top = x;
        size++;
    }
    
    public int pop() {
        int ret;

        if(size == 1){
            top = -1;
            size--;
            return f.remove();
        }

        while(f.size()>2){
            s.offer(f.remove());
        }
        top = f.remove();
        s.offer(top);
        ret = f.remove();

        Queue<Integer> temp = f;
        f = s;
        s = temp;

        second = !second;
        size--;
        return ret;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        if(size == 0)
            return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */