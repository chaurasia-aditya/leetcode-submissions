// https://leetcode.com/problems/reverse-words-in-a-string

class Solution {
    public String reverseWords(String s) {
        String[] arr=s.trim().split(" +");
        StringBuilder res = new StringBuilder();

        for(int i=0;i<arr.length;i++){
            res.insert(0, arr[i]);
            res.insert(0, ' ');
        }

        return res.toString().trim();
    }
}