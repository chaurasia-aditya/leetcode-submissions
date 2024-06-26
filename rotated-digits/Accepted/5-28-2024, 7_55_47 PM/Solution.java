// https://leetcode.com/problems/rotated-digits

class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for(int i=1;i<=n;i++){
            int cur = i;
            boolean isValid = true, isDiff = false;
            while(cur>0){
                switch(cur%10){
                    case 0:
                    case 1:
                    case 8:{
                        break;
                    }
                    case 2:
                    case 5:
                    case 6:
                    case 9:{
                        isDiff = true;
                        break;
                    }
                    case 3:
                    case 4:
                    case 7:{
                        isValid = false;
                        break;
                    }
                }
                if(!isValid)
                    break;
                cur/=10;
            }
            if(isValid && isDiff)
                count++;
        }
        
        return count;
    }
}