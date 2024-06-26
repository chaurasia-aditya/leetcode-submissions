// https://leetcode.com/problems/find-polygon-with-the-largest-perimeter

class Solution {
    public long largestPerimeter(int[] nums) {
        long per = 0, total=0, st=0;
        Arrays.sort(nums);
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            total+=nums[i];
        }
        int i;
        for(i=n-1;i>=2;i--){
            total-=nums[i];
            if(total>nums[i]){
                return total+nums[i];
            }else{
                continue;
            }
//             for(;st<i-3;st++){
                
//             }
        }
        return -1;
    }
}