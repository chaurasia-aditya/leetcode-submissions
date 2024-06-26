// https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k

class Solution {
    public int partitionArray(int[] nums, int k) {
        int max = -1;
        int count = 0;

        for(int num:nums)
            max = Math.max(max, num);

        boolean[] exists = new boolean[max+1];

        for(int num:nums)
            exists[num] = true;

        for(int i=0;i<=max;i++){
            if(exists[i] == false){
                continue;
            }
            count++;
            i+=k;
        }

        return count;
    }
}