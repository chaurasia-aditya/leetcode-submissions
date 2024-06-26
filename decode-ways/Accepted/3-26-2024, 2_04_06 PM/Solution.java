// https://leetcode.com/problems/decode-ways

class Solution {
    int countWays(String s, int i, int[] count){
        if(i == s.length())
            return 1;
        if(i>s.length())
            return 0;
        if(count[i]!=-1)
            return count[i];

        char ch = s.charAt(i);

        if(ch == '0')
            return 0;

        count[i] = countWays(s,i+1, count);

        if(i<s.length()-1 && ((ch=='1' && s.charAt(i+1)<='9') || (ch=='2' && s.charAt(i+1)<='6'))){
            count[i]+= countWays(s, i+2, count);
        }

        return count[i];

    }
    public int numDecodings(String s) {
        int[] count = new int[s.length()+1];
        Arrays.fill(count,-1);

        // count[0] = 1;
        // count[1] = 1;
        
        // if(s.charAt(0) == '0')
        //     return 0;

        return countWays(s,0,count);
    }
}