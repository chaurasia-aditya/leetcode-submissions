// https://leetcode.com/problems/string-compression-iii

class Solution {
    public String compressedString(String word) {
        if(word.length() == 0)
            return word;
        StringBuilder sb = new StringBuilder();
        
        char cur = word.charAt(0);
        int count = 1;
        for(int i=1; i<word.length();i++){
            char ch = word.charAt(i);
            
            if(ch!=cur || (ch == cur && count==9)){
                sb.append(count);
                sb.append(cur);
                cur = ch;
                count = 1;
            }else if(ch == cur){
                count++;
            }
        }
        
        sb.append(count);
        sb.append(cur);
        
        return sb.toString();
    }
}