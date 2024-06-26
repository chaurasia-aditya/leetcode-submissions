// https://leetcode.com/problems/word-pattern

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length!=pattern.length())
            return false;

        HashMap<Character, String> hm = new HashMap<>();
        char ch;
        String cur;
        boolean found;
        for(int i=0;i<pattern.length();i++)
        {
            ch = pattern.charAt(i);
            cur = words[i];
            found = hm.containsKey(ch);

            if(found && !hm.get(ch).equals(cur)){
                return false;
            }else if(!found){
                if(hm.containsValue(cur))
                    return false;
                hm.put(ch, cur);
            }
        }
        return true;
    }
}