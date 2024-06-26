// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<2){
            return s.length();
        }
        int i, j, val, max = 1;
        HashMap<Character, Integer> found = new HashMap<>();
        for(i=0,j=0;i<s.length() && j<s.length();){
            if(found.containsKey(s.charAt(j))){
                val = found.get(s.charAt(j));
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
        // int i=0, j = 1, max = 0;
        // int[] present = new int[256];
        // Arrays.fill(present, -1);
        // present[s.charAt(0)] = 0;
        // for(;i<s.length() && j<s.length();){
        //     while(j<s.length()){
        //         if(present[s.charAt(j)]!=-1){
        //             max = Math.max(j-i, max);
        //             break;
        //         }
        //         present[s.charAt(j)]=j;
        //         j++;
        //     }
        //     while(i<=present[(s.charAt(j) - 'a')]){
        //         present[s.charAt(i)] = -1;
        //         i++;
        //     }
        //     present[s.charAt(j)] = j;
        //     j++;
        // }
        // return Math.max(max, j-i);
    }
}