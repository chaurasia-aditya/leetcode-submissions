// https://leetcode.com/problems/valid-anagram

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        Map<Character, Integer> hm1= new HashMap<>();
        Map<Character, Integer> hm2 = new HashMap<>();

        for(int i=0;i<s.length();i++){
            int cur = hm1.getOrDefault(s.charAt(i), 0);
            hm1.put(s.charAt(i), cur+1);
        }

        for(int i=0;i<t.length();i++){
            int cur = hm2.getOrDefault(t.charAt(i), 0);
            hm2.put(t.charAt(i), cur+1);
        }

        if(hm1.keySet().equals(hm2.keySet()) == false){
            return false;
        }

        for(Character ch: hm1.keySet()){
            if(hm1.get(ch).equals(hm2.get(ch)) == false){
                System.out.println("ch = "+ch);
                return false;
            }
        }

        return true;
    }
}