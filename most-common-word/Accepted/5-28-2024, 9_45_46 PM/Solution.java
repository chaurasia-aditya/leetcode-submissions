// https://leetcode.com/problems/most-common-word

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> count = new HashMap<>();
        Set<String> hs = new HashSet<>();
        
        for(String s: banned){
            hs.add(s);
        }
        
        String[] p = paragraph.split("\\s*[^a-zA-Z]+\\s*");
        
        for(String s:p){
            String l = s.toLowerCase();
            if(!hs.contains(l)){
                count.put(l, count.getOrDefault(l, 0)+1);
            }
        }
        
        int max = 0;
        String maxString = "";
        
        for(Map.Entry<String, Integer> c:count.entrySet()){
            if(c.getValue()>max){
                max= c.getValue();
                maxString = c.getKey();
            }
        }
        
        return maxString;
    }
}