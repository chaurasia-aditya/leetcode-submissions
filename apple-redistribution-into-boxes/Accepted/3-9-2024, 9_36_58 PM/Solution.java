// https://leetcode.com/problems/apple-redistribution-into-boxes

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int n = apple.length;
        int m = capacity.length-1;
        Arrays.sort(capacity);
        int cap = capacity[m];
        int total = 0;
        for(int i=0;i<n;i++)
        {
            total+=apple[i];
            if(total>cap){
                m--;
                cap+=capacity[m];
            }
        }
        while(total>cap){
            m--;
            cap+=capacity[m];
        }
        return capacity.length-m;
    }
}