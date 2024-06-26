// https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii

class Solution {
    public int minimumPushes(String word) {
        Integer[] count = new Integer[26];
        int res=0;
        
        for(int i=0;i<26;i++)
            count[i]=0;
        
        for(char ch:word.toCharArray()){
            count[ch-'a']++;
        }
        
        Arrays.sort(count, Collections.reverseOrder());
        
        for(int i=0;i<26;i++){
            if(count[i]==0)
                break;
            res+=(count[i])*(i/8 + 1);
        }
        
        return res;
    }
}