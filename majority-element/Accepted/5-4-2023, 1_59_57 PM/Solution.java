// https://leetcode.com/problems/majority-element

class Solution {
    public int majorityElement(int[] nums) {
        int c = nums.length/2;
        /* //Hashing
        Hashmap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
            if(hm.get(nums[i])>c)
                return nums[i];
        }
        return -1;*/

        //Moore's Voting Algorithm
        int maj_index=0, count=1;

        for(int i=1;i<nums.length;i++){
            if(nums[maj_index]==nums[i]){
                count++;
            }else{
                count--;
            }

            if(count==0){
                maj_index = i;
                count=1;
            }
        }
        return nums[maj_index];
/* //Since guaranteed that majority element is present
        count = 0;
        for(int i:nums){
            if(i == nums[maj_index])
                count++;
        }
        if(count>c)
            return nums[maj_index];
        return -1;
*/
    }
}