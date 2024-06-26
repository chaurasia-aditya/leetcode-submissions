// https://leetcode.com/problems/count-tested-devices-after-test-operations

class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int count = 0;
        int sub = 0;
        
        for(int i: batteryPercentages){
            if(i-sub>0){
                count++;
                sub++;
            }
        }
        return count;
    }
}