// https://leetcode.com/problems/permutation-in-string

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length())
            return false;
        int[] arr = new int[26];
        int[] cur = new int[26];
        int n = s1.length();
        for(char ch: s1.toCharArray()){
            arr[ch-'a']++;
        }
        int low = 0, high = 0;
        while(high<n){
            cur[s2.charAt(high)-'a']++;
            high++;
        }
        high--;
        while(high<s2.length()){
            if(Arrays.compare(arr, cur) == 0)
                return true;
            high++;
            if(high == s2.length())
                break;
            cur[s2.charAt(high)-'a']++;
            cur[s2.charAt(low)-'a']--;
            low++;
        }
        return Arrays.compare(arr, cur) == 0? true:false;
    }
}