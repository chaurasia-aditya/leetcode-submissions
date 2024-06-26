// https://leetcode.com/problems/most-common-word

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>();
        
        for(String s: banned)    
            ban.add(s);
        
        Map<String, Integer> hm = new HashMap<>();
        
        
        String[] words = paragraph.split("\\s*[^a-zA-Z]+\\s*");
        
        for(String s: words){
            String word = s.toLowerCase(); 
            if(!ban.contains(word))
                hm.put(word, hm.getOrDefault(word, 0)+1);
        }
        
        int max = -1;
        String res = "";
        
        for(Map.Entry<String, Integer> e:hm.entrySet()){
            if(e.getValue()>max){
                max = e.getValue();
                res = e.getKey();
            }
        }
        
        return res;
    }
}