// https://leetcode.com/problems/find-subarray-with-bitwise-or-closest-to-k

class Solution {
    public int minimumDifference(int[] nums, int target) {
//         int n = nums.length;
//         int min = Integer.MAX_VALUE;

//         for (int i = 0; i < n; i++) {
//             int cur = nums[i];
//             for (int j = i; j < n; j++) {
//                 cur &= nums[j];
//                 int diff = Math.abs(k - cur);
//                 if (diff < min) {
//                     min = diff;
//                 }
//                 if (min == 0) {
//                     return 0;
//                 }
//                 if(cur == 0)
//                     break;
//             }
//         }
        
//         int n = nums.length;
//         int min = Integer.MAX_VALUE;
//         int cur = -1;
        
//         int start = 0;
//         for (int end = 0; end < n; end++) {
//             if (cur == -1) {
//                 cur = nums[end];
//             } else {
//                 cur &= nums[end];
//             }
            
//             while (start <= end && cur < k) {
//                 min = Math.min(min, Math.abs(k - cur));
//                 if (min == 0) {
//                     return 0;
//                 }
//                 cur &= ~nums[start];
//                 start++;
//             }
            
//             min = Math.min(min, Math.abs(k - cur));
//             if (min == 0) {
//                 return 0;
//             }
//         }

        int currentAND = nums[0];
        int bestDiff = Math.abs(currentAND - target);

        Map<Integer, Integer> windowBitCounts = new HashMap<>();
        int[] setBits = getSetBits(nums[0]);
        for (int bit : setBits) {
            windowBitCounts.put(bit, 1);
        }

        int left = 0, right = 0;
        while (right < nums.length) {
            if (currentAND > target || left > right) {
                right++;
                if (right >= nums.length) {
                    break;
                }
                int[] newSetBits = getSetBits(nums[right]);
                for (int bit : newSetBits) {
                    windowBitCounts.put(bit, windowBitCounts.getOrDefault(bit, 0) + 1);
                }
            } else {
                for (int bit : getSetBits(nums[left])) {
                    windowBitCounts.put(bit, windowBitCounts.get(bit) - 1);
                    if (windowBitCounts.get(bit) == 0) {
                        windowBitCounts.remove(bit);
                    }
                }
                left++;
            }

            currentAND = countsToBitwiseAnd(right - left + 1, windowBitCounts);

            if (left <= right) {
                bestDiff = Math.min(bestDiff, Math.abs(currentAND - target));
            }
        }

        return bestDiff;
    }

    private static int[] getSetBits(int x) {
        List<Integer> bits = new ArrayList<>();
        for (int i = 0; x > 0; i++) {
            if ((x & 1) == 1) {
                bits.add(i);
            }
            x >>= 1;
        }
        return bits.stream().mapToInt(i -> i).toArray();
    }

    private static int countsToBitwiseAnd(int windowLength, Map<Integer, Integer> bitCounts) {
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : bitCounts.entrySet()) {
            if (entry.getValue() == windowLength) {
                result |= (1 << entry.getKey());
            }
        }
        return result;
    }
}