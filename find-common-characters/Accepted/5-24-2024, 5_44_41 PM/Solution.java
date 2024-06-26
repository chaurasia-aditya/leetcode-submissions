// https://leetcode.com/problems/find-common-characters

class Solution {
    public List<String> commonChars(String[] words) {
        int[] count = new int[26];
        
        Arrays.fill(count, 10001);
        
        for(String s:words){
            int[] temp = new int[26];
            for(char ch: s.toCharArray()){
                temp[ch-'a']++;
            }
            
            for(int i=0;i<26;i++){
                count[i] = Math.min(count[i], temp[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for(int i = 0; i<26;i++){
            while(count[i]-->0){
                res.add(String.valueOf((char)(i+'a')));
            }
        }
        
        return res;
    }
}