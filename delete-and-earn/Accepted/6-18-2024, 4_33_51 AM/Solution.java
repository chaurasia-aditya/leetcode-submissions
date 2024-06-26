// https://leetcode.com/problems/delete-and-earn

class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        List<Integer> unique = new ArrayList<>();

        int max = 0;

        for(int num:nums){
            count[num]++;
            if(!unique.contains(num))
                unique.add(num);
        }

        Collections.sort(unique);
        int size = unique.size();

        int[] dp = new int[size];
        
        dp[0] = unique.get(0)*count[unique.get(0)];

        for(int i=1;i<size;i++){
            int cur = unique.get(i);
            dp[i] = count[cur]*cur;
            if(unique.get(i-1) == cur-1){
                dp[i] = Math.max(dp[i], dp[i-1]); 
                if(i>1){
                    dp[i] = Math.max(dp[i], dp[i-2]+count[cur]*cur);
                }
            }else{
                dp[i] = dp[i-1]+count[cur]*cur;
            }
        }

        return dp[size-1];
    }
}