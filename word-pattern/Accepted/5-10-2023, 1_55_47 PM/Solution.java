// https://leetcode.com/problems/word-pattern

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length!=pattern.length())
            return false;

        HashMap<Character, Integer> hm = new HashMap<>();
        HashSet<String> hs = new HashSet<>();
        char ch;
        String cur;
        boolean found;
        for(int i=0;i<pattern.length();i++)
        {
            ch = pattern.charAt(i);
            cur = words[i];
            found = hm.containsKey(ch);

            if(found && words[hm.get(ch)].compareTo(cur)!=0){
                return false;
            }else if(!found){
                if(hs.contains(cur))
                    return false;
                hm.put(ch, i);
                hs.add(cur);
            }
        }
        return true;
    }
}