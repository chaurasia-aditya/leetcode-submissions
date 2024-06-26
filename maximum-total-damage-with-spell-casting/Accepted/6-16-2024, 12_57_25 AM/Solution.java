// https://leetcode.com/problems/maximum-total-damage-with-spell-casting

class Solution {
    public long maximumTotalDamage(int[] power) {
        long res = 0;
        
        Map<Integer, Integer> counts = new HashMap<>();
        
        for(int p:power)
            counts.put(p, counts.getOrDefault(p, 0)+1);
        
        int[] arr = counts.keySet().stream().mapToInt(Integer::intValue).toArray();
        
        Arrays.sort(arr);
        int n = arr.length;
        
        long[] dp = new long[n];
        
        
        for(int i=0;i<n;i++){
            long cur = (long)counts.get(arr[i])*arr[i];
            
            if(i==0){
                dp[i] = cur;
            }else{
                dp[i] = dp[i-1];//exclude
               
                int j = i-1;
                while(j>=0 && arr[i]-arr[j]<=2){
                    j--;
                }
                if(j>=0)
                    cur+=dp[j];
                dp[i] = Math.max(dp[i], cur);                    
            }
        }
        
        return dp[n-1];
    }
}