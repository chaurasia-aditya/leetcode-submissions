// https://leetcode.com/problems/longest-common-subsequence

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[][] sub = new int[l1+1][l2+1];

        for(int i=0;i<l1;i++){
            for(int j=0;j<l2;j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    sub[i+1][j+1] = sub[i][j]+1;
                }else{
                    sub[i+1][j+1] = Math.max(sub[i][j+1], sub[i+1][j]);
                }
                // sub[i+1][j+1] = Math.max(sub[i][j+1], sub[i+1][j])+(text1.charAt(i)==text2.charAt(j)?1:0);
            }
        }
        return sub[l1][l2];
    }
}