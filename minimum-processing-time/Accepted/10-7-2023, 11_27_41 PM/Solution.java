// https://leetcode.com/problems/minimum-processing-time

class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks);
        
        int min = Integer.MIN_VALUE;
        int cur;
        for(int i=tasks.size()-1,j=0;i>=0;i-=4,j++){
            // System.out.println(processorTime.get(j)+" "+tasks.get(i));
            cur = processorTime.get(j)+tasks.get(i);
            min = (cur>min)?cur:min;
        }
        
        return min;
    }
}