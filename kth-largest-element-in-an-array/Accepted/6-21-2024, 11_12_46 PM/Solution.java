// https://leetcode.com/problems/kth-largest-element-in-an-array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();       

        for(int num:nums){
            if(pq.size() < k){
                pq.offer(num);
            }else if(pq.size() == k && pq.peek()<num){
                pq.poll();
                pq.offer(num);
            }
        }

        return pq.poll();
    }
}