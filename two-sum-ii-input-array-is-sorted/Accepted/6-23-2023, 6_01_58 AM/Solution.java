// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // int[] pos = new int[2001];
        // Arrays.fill(pos, -1);

        // for(int i=0;i<numbers.length;i++){
        //     int rem = target-numbers[i]+1000;
        //     if(rem<2001 && rem>=0 && pos[rem]!=-1){
        //         return new int[]{pos[rem], i+1};
        //     }
        //     pos[numbers[i]+1000] = i+1;
        // }
        // return new int[]{-1,-1};
        int low = 0, high = numbers.length-1;
        int sum;
        while(low<high){
            sum = numbers[low]+numbers[high];
            if(sum == target){
                return new int[]{low+1,high+1};
            }else if(sum<target){
                low++;
            }else{
                high--;
            }
        }
        return new int[]{-1,-1};
    }
}