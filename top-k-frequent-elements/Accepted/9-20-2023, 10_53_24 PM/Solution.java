// https://leetcode.com/problems/top-k-frequent-elements

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Map<Integer, Integer> hm = new HashMap<>();
        // int[] res = new int[k];
        // for(int i:nums){
        //     hm.put(i, hm.getOrDefault(i, 0)+1);
        // }
        // List<Map.Entry<Integer,Integer> > a = new ArrayList<>(hm.entrySet());
        // Collections.sort(a, new Comparator<Map.Entry<Integer, Integer>>(){
        //     public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
        //         return o2.getValue() - o1.getValue();
        //     }
        // });
        // for (int i = 0; i < k; i++){
        //     res[i] = a.get(i).getKey();
        // }
        // return res;
        
        
        Map<Integer, Integer> hm = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        int[] res = new int[k];
        for(int i:nums){
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }

        for(int key:hm.keySet()) {
            int count = hm.get(key);
            List<Integer> list = bucket[count];
            if(list == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(key);
        }

        int j = 0;
        for(int i=bucket.length-1;i>=0 && j<k;i--) {
            if(bucket[i] != null) {
                for(int element:bucket[i]) {
                    res[j++] = element;
                }
            }
        }
        return res;
    }
}