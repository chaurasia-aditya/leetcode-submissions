// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // HashMap<Integer, Integer> hm = new HashMap<>();
        // for(int i=0;i<numbers.length;i++){
        //     if(hm.containsKey(target-numbers[i])){
        //         return new int[]{hm.get(target-numbers[i]), i+1};
        //     }
        //     hm.put(numbers[i],i+1);
        // }
        // return null;
        int low = 0, high = numbers.length-1;
        while(low<high){
            if(numbers[low]+numbers[high] == target){
                return new int[]{low+1, high+1};
            }else if(numbers[low]+numbers[high] < target){
                low++;
            }else{
                high--;
            }
        }
        return null;
    }
}