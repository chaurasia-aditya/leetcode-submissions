// https://leetcode.com/problems/move-zeroes

void moveZeroes(int* nums, int numsSize) {
    int swap_offset = 0;
    for(int i=0;i<numsSize;i++){
        int temp = nums[i];
        nums[i] = nums[i-swap_offset];
        nums[i-swap_offset] = temp;
        if(temp == 0){
            swap_offset++;
        }
    }
}