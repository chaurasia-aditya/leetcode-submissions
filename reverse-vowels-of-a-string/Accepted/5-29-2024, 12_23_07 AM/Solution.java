// https://leetcode.com/problems/reverse-vowels-of-a-string

class Solution {        
    public boolean isVowel(char c)
    {
        if(c=='a' || c=='A' || c=='e' || c=='E' || c=='i' || c=='I' || c=='o' || c=='O' || c=='u' || c=='U')
        {    
            return true;
        }    
        return false;    
    }
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int i=0, j = str.length-1;
        
        while(i<j){
            char ci = str[i];
            char cj = str[j];
            if(isVowel(ci) && isVowel(cj)){
                str[i++] = cj;
                str[j--] = ci;
            }else{
                if(!isVowel(ci))
                    i++;
                if(!isVowel(cj))
                    j--;
            }
        }
        
        return new String(str);
    }
}