// https://leetcode.com/problems/design-circular-queue

class MyCircularQueue {

    int maxSize, curSize;
    List<Integer> list;

    public MyCircularQueue(int k) {
        list = new LinkedList<>();
        maxSize = k;
        curSize = 0;
    }
    
    public boolean enQueue(int value) {
        if(curSize == maxSize)
            return false;
        list.add(value);
        curSize++;
        return true;
    }
    
    public boolean deQueue() {
        if(curSize == 0)
            return false;
        list.remove(0);
        curSize--;
        return true;
    }
    
    public int Front() {
        if(curSize == 0)
            return -1;
        return list.get(0);
    }
    
    public int Rear() {
        if(curSize == 0)
            return -1;
        return list.get(curSize-1);
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