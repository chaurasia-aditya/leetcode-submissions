// https://leetcode.com/problems/find-common-characters

class Solution {
    public List<String> commonChars(String[] words) {
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);

        for(String s:words){
            int[] cur = new int[26];
            for(char ch:s.toCharArray()){
                cur[ch-'a']++;
            }
            for(int i=0;i<26;i++){
                count[i] = Math.min(count[i], cur[i]);
            }
        }

        List<String> res = new ArrayList<>();
        for(int i=0;i<26;i++){
            String c = String.valueOf((char)('a'+i));
            while(count[i]-->0){
                res.add(c);
            }
        }

        return res;
    }
}