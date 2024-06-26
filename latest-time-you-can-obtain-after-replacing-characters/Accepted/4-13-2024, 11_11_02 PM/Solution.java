// https://leetcode.com/problems/latest-time-you-can-obtain-after-replacing-characters

class Solution {
    public String findLatestTime(String s) {     
        char[] time = s.toCharArray();
        
        for (int i = 0; i < time.length; i++) {
            if (time[i] == '?') {
                if (i == 0) {
                    time[i] = (time[i + 1] == '?' || time[i + 1] < '2') ? '1' : '0';
                } else if (i == 1) {
                    time[i] = (time[i - 1] == '1') ? '1' : '9';
                } else if (i == 3) {
                    time[i] = '5';
                } else if (i == 4) {
                    time[i] = '9';
                }
            }
        }
        
        return new String(time);
    }
}