// https://leetcode.com/problems/design-circular-queue




typedef struct {
    int *queue;
    int k;
    int end, start;
} MyCircularQueue;

MyCircularQueue* myCircularQueueCreate(int k) {
    MyCircularQueue *cq = (MyCircularQueue*)malloc(sizeof(MyCircularQueue));
    cq->queue = (int*) malloc(k*sizeof(int));
    cq->end = -1;
    cq->start = -1;
    cq->k = k;
    return cq;
}

bool myCircularQueueIsEmpty(MyCircularQueue* obj) {
    if(obj->start == -1)
        return true;
    return false;
}

bool myCircularQueueIsFull(MyCircularQueue* obj) {
    if((obj->start == obj->end+1) || (obj->start == 0 && obj->end == obj->k-1))
        return true;
    return false;
}

bool myCircularQueueEnQueue(MyCircularQueue* obj, int value) {
    if(myCircularQueueIsFull(obj)){
        return false;
    }
    if(obj->start == -1){
        obj->start++;
    }
    obj->end = (obj->end+1)%obj->k;
    obj->queue[obj->end] = value;
    
    return true;
}

bool myCircularQueueDeQueue(MyCircularQueue* obj) {
    if(myCircularQueueIsEmpty(obj))
        return false;
    if(obj->start == obj->end){
        obj->start = obj->end = -1;
    }else{
        obj->start = ((obj->start+1)%obj->k);
    }
    return true;
}

int myCircularQueueFront(MyCircularQueue* obj) {
    if(myCircularQueueIsEmpty(obj))
        return -1;
    return obj->queue[obj->start];
}

int myCircularQueueRear(MyCircularQueue* obj) {
    if(myCircularQueueIsEmpty(obj))
        return -1;
    return obj->queue[obj->end];
}

void myCircularQueueFree(MyCircularQueue* obj) {
    free(obj->queue);
    free(obj);
}

/**
 * Your MyCircularQueue struct will be instantiated and called as such:
 * MyCircularQueue* obj = myCircularQueueCreate(k);
 * bool param_1 = myCircularQueueEnQueue(obj, value);
 
 * bool param_2 = myCircularQueueDeQueue(obj);
 
 * int param_3 = myCircularQueueFront(obj);
 
 * int param_4 = myCircularQueueRear(obj);
 
 * bool param_5 = myCircularQueueIsEmpty(obj);
 
 * bool param_6 = myCircularQueueIsFull(obj);
 
 * myCircularQueueFree(obj);
*/