// https://leetcode.com/problems/longest-absolute-file-path

class Solution {
    public int lengthLongestPath(String input) {
        int res = 0;
        Map<Integer, Integer> paths = new HashMap<>();
        
        paths.put(0, 0);
        
        String[] lines =  input.split("\n");
        
        for(String line:lines){
            String path = line.replaceAll("\t", "");
            int tabs = line.length() - path.length();

            if (path.contains(".")) {
                res = Math.max(res, paths.get(tabs) + path.length());
            } else {
                paths.put(tabs + 1, paths.get(tabs) + path.length() + 1);
            }
        }
        
        return res;
    }
}