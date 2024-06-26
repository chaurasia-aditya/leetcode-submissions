// https://leetcode.com/problems/minimum-increment-to-make-array-unique

class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return 0;

        int count = 0;
        int max = 0;

        for(int num:nums)
            max = Math.max(num, max);

        int[] freq = new int[n+max+1];

        for(int num:nums)
            freq[num]++;

        for(int i=0;i<=n+max;i++){
            if(freq[i]<=0)
                continue;
            else{
                freq[i+1] += freq[i]-1;
                count+=(freq[i]-1);
                freq[i] = 1;
            }
        }

        return count;
    }
}