// https://leetcode.com/problems/kth-largest-element-in-a-stream

class KthLargest {
    private int k;
    List<Integer> ll;
    int kth;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        ll = new LinkedList<>();
        for(int i=0;i<k;i++){
            if(pq.peek() == null)
                break;
            ll.add(pq.poll());
        }
        // System.out.println(ll);
        if(ll.size()==k)
            kth = ll.get(ll.size()-1);
    }   
    
    public int add(int val) {
        if(ll.size()<k||val>kth){
            int pos = Collections.binarySearch(ll, val, Collections.reverseOrder());
            if (pos < 0) {
                ll.add(-pos-1, val);
            }else{
                ll.add(pos, val);
            }
            kth = ll.get(k-1);
        }
        return kth;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */