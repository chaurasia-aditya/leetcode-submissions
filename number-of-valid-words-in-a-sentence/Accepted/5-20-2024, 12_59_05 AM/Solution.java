// https://leetcode.com/problems/number-of-valid-words-in-a-sentence

class Solution {
    public int countValidWords(String s) {
        int res = 0;
        int n = s.length();

        boolean hyphen = false, notValid = false;

        for(int i=0; i<n;){
            char ch = s.charAt(i);
            if(ch == ' '){
                if(i!=0 && s.charAt(i-1)!=' ' && !notValid){
                    System.out.println("s.charAt(i-1) = "+ s.charAt(i-1));
                    res++;
                }
                hyphen = false;
                notValid = false;
                while(i<n && s.charAt(i)==' ')
                    i++;
                continue;
            } else if(ch>='a' && ch <='z'){
                i++;
                continue;
            } else if(ch>='0' && ch<='9'){
                notValid = true;
            } else if(ch == '-'){
                if(!(i!=0 && i!=n-1 && s.charAt(i-1)>='a' && s.charAt(i-1)<='z' && 
                s.charAt(i+1)>='a' && s.charAt(i+1)<='z' && hyphen == false)){
                    notValid = true;
                }else{
                    hyphen = true;
                }
            } else{
                if(!((i!=n-1 && s.charAt(i+1) == ' ') || (i==n-1))){
                    notValid = true;
                }
            }

            if(notValid){
                while(i<n && s.charAt(i)!=' ')
                    i++;
                continue;
            }

            i++;
        }

        if(s.charAt(n-1)!=' ' && !notValid)
            res++;

        return res;
    }
}