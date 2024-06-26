// https://leetcode.com/problems/move-zeroes

void moveZeroes(int* nums, int numsSize) {
    int count = 0;

    for (int i = 0; i < numsSize; i++) {
        nums[i - count] = nums[i];
        if (nums[i] == 0)
            count++;
    }
    for (int i = numsSize - 1; i >= numsSize - count; i--)
        nums[i] = 0;
}