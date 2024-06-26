// https://leetcode.com/problems/height-checker

class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);
        
        int count = 0;
        
        for(int i=0;i<heights.length;i++){
            count+= (heights[i]!=expected[i]?1:0);
        }
        
        return count;
    }
}