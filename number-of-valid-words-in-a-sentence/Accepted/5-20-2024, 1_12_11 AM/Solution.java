// https://leetcode.com/problems/number-of-valid-words-in-a-sentence

import java.util.StringTokenizer;
class Solution {
    public int countValidWords(String sentence) {
        int res = 0;
        boolean hyphen = false, notValid = false;

        StringTokenizer st = new StringTokenizer(sentence);

        while (st.hasMoreTokens()) {
            String cur = st.nextToken();
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