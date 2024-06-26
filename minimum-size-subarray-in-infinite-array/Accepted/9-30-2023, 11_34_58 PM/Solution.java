// https://leetcode.com/problems/minimum-size-subarray-in-infinite-array

class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        int total = 0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        
        int full = (target/total)*nums.length;
        System.out.println("full = "+full);
        target = target%total;
        if(target == 0){
            return full;
        }
        
        int[] nums2 = new int[nums.length*2];
        System.arraycopy(nums, 0, nums2, 0, nums.length);
        System.arraycopy(nums, 0, nums2, nums.length, nums.length);
        
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        int left, cur = 0;
        int res = Integer.MAX_VALUE;

        for(int i = 0; i < nums2.length; i++){
            cur += nums2[i];
            if(cur == target){
                res = Math.min(res, i+1);
            }
            left = cur - target;

            if(hm.containsKey(left)){
                int index = hm.get(left);
                res = Math.min(res, i - index);
            }
            hm.put(cur, i);
        }
        // if(res == Integer.MAX_VALUE) 
        //     return -1;
        
//         int low=0, high=0;
//         long cur = nums[low];
//         int res = Integer.MAX_VALUE;
//         while(low<=high && high<nums.length){
//             System.out.println("low = "+low + " high="+high);
//             if(cur<target){
//                 high++;
//                 if(high==nums.length)
//                     break;
//                 cur+=nums[high];
//             }else if(cur>target){
//                 cur-=nums[low];
//                 low++;
//             }else{
//                 System.out.println("res recalculate");
//                 res = Math.min(res, high-low+1);
//                 if(high == low && high<nums.length){
                    
//                 }
//                 cur-=nums[low];
//                 low++;
//             }
//         }
        if(res == Integer.MAX_VALUE)
            return -1;
        return full+res;
    }
}