// https://leetcode.com/problems/kth-largest-element-in-a-stream

class KthLargest {
    int k;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k, (a,b) -> (a-b));
        
        for(int i:nums){
            if(pq.size() == k){ 
                if(pq.peek()<i){
                    pq.poll();
                    pq.add(i);
                }
            }else{
                pq.add(i);
            }
        }
    }
    
    public int add(int i) {
        if(pq.size() == k){ 
            if(pq.peek()<i){
                pq.poll();
                pq.add(i);
            }
        }else{
            pq.add(i);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */