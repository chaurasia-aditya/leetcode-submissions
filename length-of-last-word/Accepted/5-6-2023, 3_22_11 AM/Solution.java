// https://leetcode.com/problems/length-of-last-word

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.length()-1-s.lastIndexOf(' ');
    }
}