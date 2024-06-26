// https://leetcode.com/problems/interleaving-string

class Solution {
    boolean ans = false;

    Boolean[][] memo;

    boolean check(int i, int j, int k, int n1, int n2, int n3, String s1, String s2, String s3, boolean is1){
        if(i == n1 && j==n2 && k==n3){
            ans = true;
            return true;
        }

        if(k>=n3)
            return false;

        if(memo[i][j]!=null)
            return memo[i][j];
        
        System.out.println("i="+i+" j="+j+" k="+k);

        int offset = 0;
        if (is1) {
            for (;i + offset < n1 && k + offset < n3 && s1.charAt(i + offset) == s3.charAt(k + offset); offset++) {
                if (check(i + 1 + offset, j, k + 1 + offset, n1, n2, n3, s1, s2, s3, false)) {
                    return memo[i][j] = true;
                }
            }
        } else {
            for (;j + offset < n2 && k + offset < n3 && s2.charAt(j + offset) == s3.charAt(k + offset); offset++) {
                if (check(i, j + 1 + offset, k + 1 + offset, n1, n2, n3, s1, s2, s3, true)) {
                    return memo[i][j] = true;
                }
            }
        }

        return memo[i][j] = false;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();

        if(n3 != n1+n2)
            return false;
        
        memo = new Boolean[n1+1][n2+1];

        boolean ret = check(0, 0, 0, n1, n2, n3, s1, s2, s3, true);
        memo = new Boolean[n1+1][n2+1];
        ret |= check(0, 0, 0, n1, n2, n3, s1, s2, s3, false);

        return ret;
    }
}