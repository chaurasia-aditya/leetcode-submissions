// https://leetcode.com/problems/sort-an-array

class Solution {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    int generatePivot(int low, int high){
        Random random = new Random();
        return random.nextInt(high-low+1)+low;
    } 

    public void quicksort(int[] nums, int low, int high){
        if(low<high){
            int pivot = generatePivot(low, high);
            int value = nums[pivot];

            swap(nums, pivot, high);
            int i = low-1;
            for(int j = low; j<high; j++){
                if(nums[j]<value){
                    i++;
                    swap(nums, i, j);
                }
            }

            swap(nums, i+1, high);

            quicksort(nums, low, i);
            quicksort(nums, i+2, high);
        }
    }
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length-1);
        return nums;
    }
}