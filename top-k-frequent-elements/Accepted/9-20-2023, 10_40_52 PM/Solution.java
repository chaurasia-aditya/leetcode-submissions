// https://leetcode.com/problems/top-k-frequent-elements

class Solution {
    // class element {
    //     public int value;
    //     public int count;
            
    //     // A parameterized student constructor
    //     public element(int v, int count) {
    //         this.value = v;
    //         this.count = count;
    //     }
    // }   
    // class elementCount implements Comparator<element>{
    //     public int compare(element s1, element s2) {
    //         if (s1.count < s2.count)
    //             return 1;
    //         else if (s1.count > s2.count)
    //             return -1;
    //         return 0;
    //     }
    // }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int[] res = new int[k];
        for(int i:nums){
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }
        List<Map.Entry<Integer,Integer> > a = new ArrayList<>(hm.entrySet());
        Collections.sort(a, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
                return o2.getValue() - o1.getValue();
            }
        });
        for (int i = 0; i < k; i++){
            res[i] = a.get(i).getKey();
        }
        return res;
    }
}