// https://leetcode.com/problems/number-of-valid-words-in-a-sentence

class Solution {
    public int countValidWords(String sentence) {
        int res = 0;
        // int n = s.length();

        String[] tokens = sentence.trim().split("\\s+");

        boolean hyphen = false, notValid = false;

        for(String cur:tokens){
            int n = cur.length();
            hyphen = false;
            notValid = false;

            for(int i=0;i<cur.length();i++){
                char ch = cur.charAt(i);
                if(ch>='a' && ch <='z'){
                    continue;
                } else if(ch>='0' && ch<='9'){
                    notValid = true;
                    break;
                } else if(ch == '-'){
                    if(!(i!=0 && i!=n-1 && cur.charAt(i-1)>='a' && cur.charAt(i-1)<='z' && 
                    cur.charAt(i+1)>='a' && cur.charAt(i+1)<='z' && hyphen == false)){
                        notValid = true;
                        break;
                    }else{
                        hyphen = true;
                    }
                } else{
                    if(!((i!=n-1 && cur.charAt(i+1) == ' ') || (i==n-1))){
                        notValid = true;
                        break;
                    }
                }
            }
            if(!notValid)
                res++;
        }

        return res;
    }
}