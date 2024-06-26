// https://leetcode.com/problems/removing-stars-from-a-string

class Solution {
    public String removeStars(String s) {
        ArrayList<Character> al = new ArrayList<>();
        int size = -1;     
        for(char ch: s.toCharArray()){
            if(ch == '*'){
                size--;
            }else{
                al.add(++size, ch);
            }
        }
        if(size == -1){
            return "";
        }

        StringBuilder sb = new StringBuilder(size);
        for(int i=0;i<=size;i++)
        {
            sb.append(al.get(i));
        }
        return sb.toString();
    }
}