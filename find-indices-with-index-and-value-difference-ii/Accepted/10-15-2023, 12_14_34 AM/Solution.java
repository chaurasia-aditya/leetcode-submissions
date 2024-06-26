// https://leetcode.com/problems/find-indices-with-index-and-value-difference-ii

class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;
        int[] res = {-1,-1};
        int[] min_f = new int[nums.length];
        int[] min_r = new int[nums.length];
        int[] max_f = new int[nums.length];
        int[] max_r = new int[nums.length];
        min_f[0] = 0;
        min_r[n-1] = n-1;
        max_f[0] = 0;
        max_r[nums.length-1] = n-1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[min_f[i-1]]){
                min_f[i] = i;   
            }else{
                min_f[i] = min_f[i-1];
            }
            
            if(nums[i]>nums[max_f[i-1]]){
                max_f[i] = i;   
            }else{
                max_f[i] = max_f[i-1];
            }
            
            if(nums[min_r[nums.length-i]]>nums[nums.length-1-i]){
                min_r[nums.length-1-i] = nums.length-1-i;   
            }else{
                min_r[nums.length-1-i] = min_r[nums.length-i];
            }
            
            if(nums[nums.length-1-i]>nums[max_r[nums.length-i]]){
                max_r[nums.length-1-i] = nums.length-i-1;   
            }else{
                max_r[nums.length-1-i] = max_r[nums.length-i];
            }
        }
        
//         for(int i=0;i<n;i++){
//             System.out.print(min_f[i]);
//         }
//         System.out.println();
        
//         for(int i=0;i<n;i++){
//             System.out.print(min_r[i]);
//         }
//         System.out.println();
        
//         for(int i=0;i<n;i++){
//             System.out.print(max_f[i]);
//         }
//         System.out.println();
        
//         for(int i=0;i<n;i++){
//             System.out.print(max_r[i]);
//         }
//         System.out.println();
        
        for(int i=0;i<nums.length-indexDifference;i++){
            if(Math.abs(nums[min_f[i]]-nums[max_r[indexDifference+i]])>=valueDifference){
                res[0] = min_f[i];
                res[1] = max_r[indexDifference+i];
                System.out.println("Here i = "+i+ "min_f = "+min_f[i]+" max_r = "+max_r[indexDifference+i]);
                break;
            }else if(Math.abs(nums[max_f[i]]-nums[min_r[indexDifference+i]])>=valueDifference){
                res[0] = max_f[i];
                res[1] = min_r[indexDifference+i];
                System.out.println("Here2 i = "+i+" max_f = "+max_f[i]+" min_r = "+min_r[indexDifference+i]);
                break;
            }
        }

        return res; 
    }
}