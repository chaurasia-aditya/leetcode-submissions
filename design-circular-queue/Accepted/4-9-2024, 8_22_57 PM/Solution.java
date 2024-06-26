// https://leetcode.com/problems/design-circular-queue

class MyCircularQueue {
    private int[] list;
    int maxSize, curSize;
    int start, end;
    // List<Integer> list;

    public MyCircularQueue(int k) {
        list = new int[k];
        maxSize = k;
        curSize = 0;
        start = 0;
        end = -1;
    }
    
    public boolean enQueue(int value) {
        if(curSize == maxSize)
            return false;

        end=(end+1)%maxSize;
        list[end] = value;

        if(start == -1){
            start = end;
        }

        curSize++;
        return true;
    }
    
    public boolean deQueue() {
        if(curSize == 0)
            return false;

        start = (start+1)%maxSize;
        curSize--;
        return true;
    }
    
    public int Front() {
        if(curSize == 0)
            return -1;
        return list[start];
    }
    
    public int Rear() {
        if(curSize == 0)
            return -1;
        return list[end];
    }
    
    public boolean isEmpty() {
        return curSize==0;
    }
    
    public boolean isFull() {
        return curSize==maxSize;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */