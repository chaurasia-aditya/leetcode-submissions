// https://leetcode.com/problems/word-pattern

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        HashMap<Character, Integer> hm = new HashMap<>();
        HashSet<String> hs = new HashSet<>();
        if(words.length!=pattern.length())
            return false;

        for(int i=0;i<pattern.length();i++)
        {
            char ch = pattern.charAt(i);
            if(hm.containsKey(ch) && words[hm.get(ch)].compareTo(words[i])!=0){
                return false;
            }else if(!hm.containsKey(ch)){
                if(hs.contains(words[i]))
                    return false;
                hm.put(ch, i);
                hs.add(words[i]);
            }
        }
        return true;
    }
}