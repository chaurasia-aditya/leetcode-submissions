// https://leetcode.com/problems/last-stone-weight

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // int n = stones.length;
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }

        while(pq.size()>1){
            int x = pq.remove();
            int y = pq.remove();
            if(x!=y){
                pq.add(x-y);
            }
        }
        return pq.isEmpty()?0:pq.remove();
    }
}