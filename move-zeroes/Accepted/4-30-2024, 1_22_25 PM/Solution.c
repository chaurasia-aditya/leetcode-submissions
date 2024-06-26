// https://leetcode.com/problems/move-zeroes

void moveZeroes(int* nums, int numsSize) {
    int move = 0;
    for(int i=0;i<numsSize;i++){
        if(nums[i] == 0){
            move++;
            continue;
        }
        nums[i-move] = nums[i];
    }
    for(int i = numsSize-move;i<numsSize;i++){
        nums[i] = 0;
    }
}