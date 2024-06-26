// https://leetcode.com/problems/majority-element-ii

import java.util.Map.Entry;
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int x = n/3;        
        List<Integer> res = new ArrayList<>();
        
        Arrays.sort(nums);
        int cur = nums[0], count = 1, size = 0;
        
        for(int i=1;i<n;i++){
            if(nums[i]!=cur){
                if(count>x){
                    res.add(cur);
                }
                cur = nums[i];
                count = 1;
            }else{
                count++;
            }
            
        }
        if(count>x){
            res.add(cur);
        }
        
        return res;
    }
}