// https://leetcode.com/problems/maximize-happiness-of-selected-children

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans = 0;
        int n = happiness.length;
        for(int i=0;i<k;i++){
            ans+=((happiness[n-1-i]-i)>0?happiness[n-1-i]-i:0);    
        }
        
        return ans;
    }
}