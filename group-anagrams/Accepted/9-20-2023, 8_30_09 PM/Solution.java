// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String> >
            map = new HashMap<HashMap<Character, Integer>, ArrayList<String>>();
        for (String str : strs) {
            HashMap<Character, Integer> tempMap = new HashMap<Character, Integer>();
            for (int i = 0; i < str.length(); i++) {
                if (tempMap.containsKey(str.charAt(i))) {
                    int x = tempMap.get(str.charAt(i));
                    tempMap.put(str.charAt(i), ++x);
                }
                else {
                    tempMap.put(str.charAt(i), 1);
                }
            }
 
            if (map.containsKey(tempMap))
                map.get(tempMap).add(str);
            else {
                ArrayList<String> tempList = new ArrayList<String>();
                tempList.add(str);
                map.put(tempMap, tempList);
            }
        }
 
        // Stores the result in a arraylist
        List<List<String>> result = new ArrayList<>();
        for (HashMap<Character, Integer> temp : map.keySet())
            result.add(map.get(temp));
        return result;
    }
}