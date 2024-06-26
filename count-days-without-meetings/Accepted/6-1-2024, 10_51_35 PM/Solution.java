// https://leetcode.com/problems/count-days-without-meetings

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b)->a[0]-b[0]);
        
        int count = 0;
        int low = -1, high = -1;
        for(int i=0;i<meetings.length;i++){
            if(low == -1){
                low = meetings[i][0];
                high = meetings[i][1];
                count+=(low-1);
            }else if(meetings[i][0]<=high){
                high = Math.max(high, meetings[i][1]);
            }else{
                low = meetings[i][0];
                count+=(low-high-1);
                high = meetings[i][1];
            }
        }
        
        count+=(days-high);
        
        return count;
    }
}