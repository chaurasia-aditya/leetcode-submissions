// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, ArrayList<String>> hm = new HashMap<Integer, ArrayList<String>>();
        for (String str : strs) {
            int[] count = new int[26];
            for(char ch: str.toCharArray()){
                count[ch-'a']++;
            }
            int anagram = (Arrays.toString(count)).hashCode();
            if(!hm.containsKey(anagram)){
                hm.put(anagram, new ArrayList<>());
            }
            hm.get(anagram).add(str);
        }
        return new ArrayList<>(hm.values());
    }
}