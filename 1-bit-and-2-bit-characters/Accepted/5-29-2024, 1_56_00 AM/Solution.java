// https://leetcode.com/problems/1-bit-and-2-bit-characters

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        
        int ones = 0;
        for(int i=0; i<n-1;i++){
            if(bits[i] == 0){
                if(ones == 1){
                    ones = 0;
                }
            }else{
                if(ones == 1)
                    ones = 0;
                else
                    ones = 1;
            }
        }
        
        return ones==0;
    }
}