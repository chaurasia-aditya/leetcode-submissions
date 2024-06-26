// https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string

class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        int count = 0, start = -1;
        int len = Integer.MAX_VALUE;
        
        String res = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1'){
                // System.out.println("i="+i);
                al.add(i);
                count++;
                if(k==1){
                    return s.substring(i,i+1);
                }
                if(count == k){
                    if(len > i-al.get(start)+1){
                        len = i-al.get(start)+1;
                        // System.out.println("len = "+len);
                        res = s.substring(al.get(start), i+1);
                    }else if(len == i-al.get(start)+1 && res.length()!=0 && res.compareTo(s.substring(al.get(start), i+1))>0){
                        res = s.substring(al.get(start), i+1);
                    }
                    count--;
                    start++;
                }else if(count == 1){
                    start = 0;
                }
            }   
        }
        return res;
    }
}