// https://leetcode.com/problems/reverse-string-ii

class Solution {
    public String reverseStr(String s, int k) {
        int i=0, j=k-1;
        char[] sArr = s.toCharArray();
        int n = sArr.length;
        
        while(j<n){
            int x=0;
            while(i+x<j-x){
                char temp = sArr[i+x];
                sArr[i+x] = sArr[j-x];
                sArr[j-x] = temp;
                x++;
            }
            i += 2*k;
            j += 2*k;
        }
        if(i<n){
            j = n-1;
            while(i<j){
                char temp = sArr[i];
                sArr[i++] = sArr[j];
                sArr[j--] = temp;
            }
        }
        
        return new String(sArr);
    }
}