// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
        for (String str : strs) {
            int[] count = new int[26];
            for(char ch: str.toCharArray()){
                count[ch-'a']++;
            }
            String anagram = Arrays.toString(count);
            if(!hm.containsKey(anagram)){
                hm.put(anagram, new ArrayList<>());
            }
            hm.get(anagram).add(str);
        }
        return new ArrayList<>(hm.values());
    }
}