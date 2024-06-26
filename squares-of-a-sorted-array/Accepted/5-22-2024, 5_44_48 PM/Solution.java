// https://leetcode.com/problems/squares-of-a-sorted-array

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] square = new int[n];
        int[] res = new int[n];
        int index = -1;
        
        while(index+1<n && nums[index+1]<0)
            index++;
        
        for(int i=0;i<n;i++){
            square[i] = nums[i]*nums[i];
        }

        int j = 0;
        int k = index+1;
        int i = index;

        for(;j<n;j++){
            if(i>=0 && k<n){
                if(square[k]<square[i])
                    res[j] = square[k++];
                else
                    res[j] = square[i--];
            }else if(k<n){
                res[j] = square[k++];    
            }else if(i>=0){
                res[j] = square[i--];
            }
        }
        
        return res;
    }
}