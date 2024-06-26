// https://leetcode.com/problems/minimum-cost-to-convert-string-i

class Solution {
    final long MAX = (long)1e18;
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] arr = new long[26][26];
        
        for(int i=0;i<26;i++){
            Arrays.fill(arr[i], MAX);
            arr[i][i] = 0;
        }
        
        for(int i=0;i<original.length;i++){
            long cur = arr[original[i]-'a'][changed[i]-'a'];
            arr[original[i]-'a'][changed[i]-'a'] = Math.min((long)cost[i], cur);
        }
        
        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                if(arr[i][k]<MAX){
                    for(int j=0;j<26;j++){
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }
        }
        
        long ans = 0;
        
        for(int i=0;i<source.length();i++){
            if(arr[source.charAt(i) - 'a'][target.charAt(i) - 'a']>=MAX){
                return -1;
            }
            ans+= arr[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
            if(ans>=MAX){
                return -1;
            }
        }
        return ans;
    }
}