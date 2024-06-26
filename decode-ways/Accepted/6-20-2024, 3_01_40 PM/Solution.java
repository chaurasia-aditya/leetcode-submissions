// https://leetcode.com/problems/decode-ways

class Solution {
    int[] memo;

    int recur(int i, char[] s, int n){
        if(i == n)
            return 1;
        if(memo[i]!=-1)
            return memo[i];
        
        if(s[i] == '0')
            return 0;
        // System.out.println("i = "+i);

        int ways=0;
        // one char
        ways+=recur(i+1, s, n);
        //2 char
        if(i+1<n){
            int cur = s[i]-'0';
            cur = cur*10+(s[i+1]-'0');
            if(cur<=26){
                // System.out.println("in if cur="+cur);
                ways+=recur(i+2, s, n);
            }
        }
        return memo[i] = ways;
    }

    public int numDecodings(String s) {
        int n = s.length();
        memo = new int[n];
        Arrays.fill(memo, -1);
        return recur(0, s.toCharArray(), n);
    }
}