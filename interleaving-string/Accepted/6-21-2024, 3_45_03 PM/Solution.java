// https://leetcode.com/problems/interleaving-string

class Solution {
    boolean ans = false;

    Boolean[][] memo;

    boolean check(int i, int j, int k, int n1, int n2, int n3, String s1, String s2, String s3, boolean is1){
        if(i == n1 && j==n2){
            ans = true;
            return true;
        }

        if(memo[i][j]!=null)
            return memo[i][j];

        boolean res = false;
        if(i<n1 && s1.charAt(i)==s3.charAt(k)){
            res |= check(i+1, j, k+1, n1, n2, n3, s1, s2, s3, false);
        }
        if(!res && j<n2 && s2.charAt(j) == s3.charAt(k)){
            res |= check(i, j+1, k+1, n1, n2, n3, s1, s2, s3, true);
        }

        return memo[i][j] = res;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();

        if(n3 != n1+n2)
            return false;
        
        memo = new Boolean[n1+1][n2+1];

        boolean ret = check(0, 0, 0, n1, n2, n3, s1, s2, s3, true)||check(0, 0, 0, n1, n2, n3, s1, s2, s3, false);
        
        return ans;
    }
}