// https://leetcode.com/problems/move-zeroes

void moveZeroes(int* nums, int numsSize) {
    int i = 0;
    int j = 0;
    while(j < numsSize)
    {
        if(nums[j] != 0)
        {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
        }
        j++;
    }
}