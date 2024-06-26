// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();
        for (String str : strs) {
            char[] count = new char[26];
            for(char ch: str.toCharArray()){
                count[ch-'a']++;
            }
            String anagram = new String(count);
            if(!hm.containsKey(anagram)){
                hm.put(anagram, new ArrayList<>());
            }
            hm.get(anagram).add(str);
        }
        return new ArrayList<>(hm.values());
    }
}