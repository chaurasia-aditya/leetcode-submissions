// https://leetcode.com/problems/student-attendance-record-i

class Solution {
    public boolean checkRecord(String s) {
        int lateCount = 0, absentCount = 0;
        
        for(char ch:s.toCharArray()){
            if(ch == 'A'){
                absentCount++;
            }else if(ch == 'L'){
                lateCount++;
                if(lateCount == 3)
                    return false;
            }
            
            if(ch!='L' && lateCount!=0)
                lateCount = 0;
        }
        
        return absentCount<2;
    }
}