// https://leetcode.com/problems/majority-element-ii

import java.util.Map.Entry;
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int x = n/3;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] count = new int[50001];
        int index = 0;
        
        for(int i=0;i<n;i++){
            if(hm.containsKey(nums[i]) == false){
                hm.put(nums[i], index);
                count[index] = 1;
                index++;
            }else{
                count[hm.get(nums[i])]++;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(Entry<Integer, Integer> e: hm.entrySet()){
            if(count[e.getValue()] > x)
                    res.add(e.getKey());
        }
        
        return res;
    }
}