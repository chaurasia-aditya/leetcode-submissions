// https://leetcode.com/problems/target-sum

class Solution {
    int count(int pos, int n, int target, int[] nums, int cur, int[][] memo){
        if(pos == n)
            if(cur==target)
                return 1;
            else
                return 0;
        if(cur>target)
            return 0;

        if(memo[pos][cur]!=-1)
            return memo[pos][cur];
        
        return memo[pos][cur] = count(pos+1, n, target, nums, cur+nums[pos], memo) + count(pos+1, n, target, nums, cur, memo);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        int[][] memo = new int[n][1001];

        for(int i = 0; i<n; i++){
            total+=nums[i];
            Arrays.fill(memo[i], -1);
        }
        
        if(total<target || (total-target)%2 == 1)
            return 0;
        
        int reduce = (total-target)/2;

        return count(0, n, reduce, nums, 0, memo);


        // int count[] = new int[reduce+1];
        // count[0] = 1;

        // for (int i = 1; i <= reduce; i++)
        //     for (int j = 0; j < arr.length; j++)
     
        //         // if i >= arr[j] then
        //         // accumulate count for value 'i' as
        //         // ways to form value 'i-arr[j]'
        //         if (i >= arr[j])
        //             count[i] += count[i - arr[j]];
         
        // // required number of ways 
        // return count[N]; 
    }
}