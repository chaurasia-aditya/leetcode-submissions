// https://leetcode.com/problems/h-index

class Solution {
    public int hIndex(int[] citations) {
        int count = 1;
        Arrays.sort(citations);
        for(int i=citations.length-1;i>=0;i--){
            if(citations[i]>=count)
                count++;
        }
        return count-1;
    }
}