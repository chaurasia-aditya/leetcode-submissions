// https://leetcode.com/problems/partition-labels

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] st = new int[26];
        int[] end = new int[26];
        int n = s.length();
        
        Arrays.fill(st, -1);
        Arrays.fill(end, -1);
        
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            
            if(st[ch-'a'] == -1)
                st[ch - 'a'] = i;
            end[ch-'a'] = i;
        }
        
        List<Integer> res = new ArrayList<>();
        
        int beg = -1;
        int ending = -1;
        
        for(int i=0;i<n;i++){
            if(beg == -1){
                beg = i;
            }
            ending = Math.max(ending, end[s.charAt(i)-'a']);
            
            if(i == ending){
                res.add(ending-beg+1);
                beg = -1;
            }
        }
        
        return res;
    }
}