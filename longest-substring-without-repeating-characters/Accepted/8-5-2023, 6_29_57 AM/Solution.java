// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<2){
            return s.length();
        }
        int i, j, index, max = 1;
        HashMap<Character, Integer> found = new HashMap<>();
        //int[] found = new int[26];
        //Arrays.fill(found, -1);
        for(i=0,j=0;i<s.length() && j<s.length();){
            //index = s.charAt(j)-'a';
            if(found.containsKey(s.charAt(j))){
                int val = found.get(s.charAt(j));
                max = Math.max(max, j-i);
                while(i<=val){
                    found.remove(s.charAt(i));
                    i++;
                }
                continue;
            }
            found.put(s.charAt(j), j);
            j++;
        }
        return max>(j-i)?max:j-i;
    }
}