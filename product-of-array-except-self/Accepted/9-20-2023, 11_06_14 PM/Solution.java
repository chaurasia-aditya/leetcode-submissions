// https://leetcode.com/problems/product-of-array-except-self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] front = new int[n];
        int[] back = new int[n];
        int [] res = new int[n];
        front[0] = nums[0];
        back[n-1] = nums[n-1];

        for(int i=1;i<n-1;i++){
            front[i] = front[i-1]*nums[i];
            back[n-1-i] = back[n-i]*nums[n-1-i]; 
        }
        res[0] = back[1];
        res[n-1] = front[n-2];
        for(int i=1;i<n-1;i++){
            res[i] = front[i-1]*back[i+1];
        }
        return res;
    }
}