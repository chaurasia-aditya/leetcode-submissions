// https://leetcode.com/problems/move-zeroes

void moveZeroes(int* nums, int numsSize) {
    int moved = 0;
    for(int i=0;i<numsSize;i++){
        int temp = nums[i];
        nums[i] = nums[i-moved];
        nums[i-moved] = temp;

        if(temp == 0)
            moved++;
    }
}