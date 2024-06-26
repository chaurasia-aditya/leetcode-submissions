// https://leetcode.com/problems/maximum-prime-difference

class Solution {
    public int maximumPrimeDifference(int[] nums) {
        boolean[] prime = new boolean[101];
        
        for (int i = 0; i <= 100; i++)
            prime[i] = true;
        prime[1] = false;
 
        for (int p = 2; p * p <= 100; p++) {

            if (prime[p] == true) {
                for (int i = p * p; i <= 100; i += p)
                    prime[i] = false;
            }
        }
        int i = 0, j = nums.length-1;
        
        for(;i<nums.length;i++){
            if(prime[nums[i]] == true)
                break;
        }
        
        for(;j>=0;j--){
            if(prime[nums[j]] == true)
                break;
        }
        
        return j-i;
    }
}