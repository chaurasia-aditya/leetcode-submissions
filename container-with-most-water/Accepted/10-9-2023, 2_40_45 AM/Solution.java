// https://leetcode.com/problems/container-with-most-water

class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length-1;

        while(i<j){
            max = Math.max(max, (j-i)*Math.min(height[i], height[j]));
            if(height[i]<height[j])
                i++;
            else
                j--;
        }
        return max;
    }
}