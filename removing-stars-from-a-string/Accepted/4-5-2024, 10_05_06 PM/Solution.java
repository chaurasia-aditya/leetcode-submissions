// https://leetcode.com/problems/removing-stars-from-a-string

class Solution {
    public String removeStars(String s) {
        char[] arr = s.toCharArray();
        int move = 0;
        int i = 0;
        for(;i<arr.length;i++){
            if(arr[i] == '*')
                move+=2;
            else{
                arr[i-move] = arr[i];
            }
        }
        if(i-move == 0){
            return "";
        }
        char[] arr2 = Arrays.copyOfRange(arr, 0, i-move);

        return new String(arr2);
    }
}