// https://leetcode.com/problems/partition-labels

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        
        int[] lastSeen = new int[26];
        
        Arrays.fill(lastSeen, -1);
        
        for(int i=0;i<n;i++){
            lastSeen[s.charAt(i)-'a'] = i;
        }
        
        int cur = lastSeen[s.charAt(0)-'a'];
        int st = 0;
        
        for(int i=1;i<n;i++){
            if(i>cur){
                res.add(i-st);  
                st = i;
                cur = lastSeen[s.charAt(i)-'a'];
            }else{
                cur = Math.max(cur, lastSeen[s.charAt(i)-'a']);
            }
        }
        
        res.add(n-st);
        
        return res;
    }
}