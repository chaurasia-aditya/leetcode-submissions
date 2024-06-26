// https://leetcode.com/problems/letter-tile-possibilities

class Solution {
    int res = 0;
    void backtrack(int[] freq){
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                res++;
                freq[i]--;
                backtrack(freq);
                freq[i]++;
            }
        }
    }
    public int numTilePossibilities(String tiles) {     
        int[] freq = new int[26];
        
        for(char ch: tiles.toCharArray()){
            freq[ch-'A']++;
        }
                
        backtrack(freq);
        
        return res;
    }
}