// https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset

class Solution {
    public int maximumLength(int[] nums) {
        int res = 1;
        int max = 31633;
        
        Arrays.sort(nums);

        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> len = new TreeMap<>();
        
        int result = 0;

        for (int num : nums) {
            if(!count.containsKey(num)){
                len.put(num, 1);
            }
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        for(int key: len.keySet()){
            // System.out.println("key = "+key+" len(key)" + len.get(key));
            if(key == 1)
                continue;
            if(key>max)
                break;
            if(count.get(key)>=2){
                int target = key*key;
                if(count.containsKey(target)){
                    // System.out.println("target = "+target+" len.get(key)+3 = "+ (len.get(key)+2));
                    len.put(target, len.get(key)+2);
                    res = Math.max(res, len.get(target));
                }
            }
        }
        
        int onelen = count.getOrDefault(1, 0);
        if((onelen&1) == 0){
            onelen--;
        }           

        return Math.max(res, onelen);
    }
}