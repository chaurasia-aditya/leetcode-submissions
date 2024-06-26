// https://leetcode.com/problems/count-prefix-and-suffix-pairs-i

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        
        for(int i=0;i<words.length-1;i++){
            int len = words[i].length();
            for(int j=i+1;j<words.length;j++){
                int len2 = words[j].length();
                if(len2<len){
                    continue;
                }
                String pre = words[j].substring(0, len);
                String suff = words[j].substring(len2-len);
                
                if(pre.equals(words[i]) && suff.equals(words[i])){
                    count++;
                }
            }
        }
        return count;
    }
}