// https://leetcode.com/problems/concatenation-of-array

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* getConcatenation(int* nums, int numsSize, int* returnSize) {
    *returnSize = numsSize*2;

    int* res = (int*)malloc((*returnSize)*sizeof(int));

    register int i = 0, j = numsSize;

    while(i<numsSize){
        res[i] = nums[i];
        res[j++] = nums[i++];
    }

    return res;
}