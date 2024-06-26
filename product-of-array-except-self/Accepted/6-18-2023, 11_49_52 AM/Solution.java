// https://leetcode.com/problems/product-of-array-except-self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        int[] res = new int[n];

        Arrays.fill(res, 1);

        pre[0] = nums[0];
        post[n-1] = nums[n-1];

        for(int i=1;i<n;i++){
            pre[i] = pre[i-1]*nums[i];
            post[n-1-i] = post[n-i]*nums[n-1-i];
        }
        for(int i=0;i<n;i++){
            if(i-1>=0){
                res[i]*=pre[i-1];
            }
            if(i+1<n){
                res[i]*=post[i+1];
            }
        }

        return res;
    }
}