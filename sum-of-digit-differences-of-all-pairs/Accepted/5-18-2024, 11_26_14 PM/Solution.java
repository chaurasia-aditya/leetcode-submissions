// https://leetcode.com/problems/sum-of-digit-differences-of-all-pairs

class Solution {
    public long sumDigitDifferences(int[] nums) {
        int n = nums.length;
        
        long count = 0;
        long pairs = n*n-1;
        
        long numDigits = String.valueOf(nums[0]).length();

        for (int i = 0; i < numDigits; i++) {
            long[] digitCount = new long[10];
            for (long num : nums) {
                int digit = String.valueOf(num).charAt(i) - '0';
                digitCount[digit]++;
            }   
            
            for (int digit1 = 0; digit1 < 10; digit1++) {
                for (int digit2 = digit1 + 1; digit2 < 10; digit2++) {
                    count += digitCount[digit1] * digitCount[digit2];
                }
            }
        }
        return count;
    }
}