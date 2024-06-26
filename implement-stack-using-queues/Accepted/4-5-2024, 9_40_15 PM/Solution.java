// https://leetcode.com/problems/implement-stack-using-queues

class MyStack {
    Queue<Integer> q;
    int size;

    public MyStack() {
        q = new LinkedList<>();
        size = 0;
    }
    
    public void push(int x) {
        if(size == 0)
            q.offer(x);
        else{
            q.offer(x);

            while(size-->0){
                q.offer(q.peek());
                q.poll();
            }
        }
        size = q.size();
    }
    
    public int pop() {
        size--;
        return q.poll();
    }
    
    public int top() {
        return q.peek();
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