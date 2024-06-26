// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] pos = new int[2001];
        Arrays.fill(pos, -1);

        for(int i=0;i<numbers.length;i++){
            int rem = target-numbers[i]+1000;
            if(rem<2001 && rem>=0 && pos[rem]!=-1){
                return new int[]{pos[rem], i+1};
            }
            pos[numbers[i]+1000] = i+1;
        }
        return new int[]{-1,-1};
    }
}