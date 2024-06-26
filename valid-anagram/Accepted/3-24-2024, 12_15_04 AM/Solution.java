// https://leetcode.com/problems/valid-anagram

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Map<Character, Integer> hm1= new HashMap<>();
        // Map<Character, Integer> hm2 = new HashMap<>();

        for(char ch: s.toCharArray()){
            // int cur = hm1.getOrDefault(s.charAt(i), 0);
            // hm1.put(s.charAt(i), cur+1);
            count1[ch -'a']++;
        }

        for(char ch: t.toCharArray()){
            // int cur = hm2.getOrDefault(t.charAt(i), 0);
            // hm2.put(t.charAt(i), cur+1);
            count2[ch-'a']++;
        }

        for(int i=0;i<26;i++){
            if(count1[i]!=count2[i])
                return false;
        }

        // if(hm1.keySet().equals(hm2.keySet()) == false){
        //     return false;
        // }

        // for(Character ch: hm1.keySet()){
        //     if(hm1.get(ch).equals(hm2.get(ch)) == false){
        //         return false;
        //     }
        // }

        return true;
    }
}