// https://leetcode.com/problems/implement-stack-using-queues

class MyStack {
    Queue<Integer> q1, q2;
    int top, size;
    boolean second;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        top = -1;
        second = false;
        size = 0;
    }

    private void print(){
        int i=0;
        System.out.println("Size = "+size+" top = "+top+" second = "+second);
        if(second){
            System.out.println(q2);
        }else{
            System.out.println(q1);
        }
    }
    
    public void push(int x) {
        if(second){
            q2.offer(x);
        }else{
            q1.offer(x);
        }
        top = x;
        size++;
        // print();
    }
    
    public int pop() {
        int ret;

        Queue<Integer> f = (second?q2:q1);
        Queue<Integer> s = (second?q1:q2);

        if(size == 1){
            top = -1;
            size--;
            print();
            return f.remove();
        }

        // if(size == 1){
        //     if(second){
        //         top = -1;
        //         size--;
        //         print();
        //         return q2.remove();
        //     }else{
        //         top = -1;
        //         size--;
        //         print();
        //         return q1.remove();
        //     }
        // }

        while(f.size()>2){
            s.offer(f.remove());
        }
        top = f.remove();
        s.offer(top);
        ret = f.remove();

        // if(second){
        //     while(q2.size() > 2){
        //         q1.offer(q2.remove());
        //     }
        //     top = q2.remove();
        //     q1.offer(top);
        //     ret = q2.remove();
        // }else{
        //     while(q1.size() > 2){
        //         q2.offer(q1.remove());
        //     }
        //     top = q1.remove();
        //     q2.offer(top);
        //     ret = q1.remove();
        // }

        second = !second;
        size--;
        // print();
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