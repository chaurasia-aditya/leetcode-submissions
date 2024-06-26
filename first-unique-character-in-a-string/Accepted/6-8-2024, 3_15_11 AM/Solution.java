// https://leetcode.com/problems/first-unique-character-in-a-string

class Solution {
    public int firstUniqChar(String s) {
        boolean[] seen = new boolean[26];
        int[] index = new int[26];
        Arrays.fill(index, -1);

        for(int i=0; i<s.length();i++){
            int in = s.charAt(i)-'a';
            if(seen[in])
                index[in] = -1;
            else{
                seen[in] = true;
                index[in] = i;
            }
        }
        int min = s.length();

        for(int i=0;i<26;i++){
            if(seen[i] && index[i]!=-1)
                min = Math.min(index[i], min);
        }

        return min==s.length()?-1:min;
    }
}