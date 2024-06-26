// https://leetcode.com/problems/find-subarray-with-bitwise-or-closest-to-k

class Solution {
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
    public int minimumDifference(int[] nums, int target) {
        int cur = nums[0];
        int n = nums.length;
        int bestDiff = Math.abs(cur - target);

        Map<Integer, Integer> bitCounts = new HashMap<>();
        int[] setBits = getSetBits(nums[0]);
        for (int bit : setBits) {
            bitCounts.put(bit, 1);
        }

        int left = 0, right = 0;
        while (right < n) {
            if (cur > target || left > right) {
                right++;
                if (right >= nums.length) {
                    break;
                }
                int[] newSetBits = getSetBits(nums[right]);
                for (int bit : newSetBits) {
                    bitCounts.put(bit, bitCounts.getOrDefault(bit, 0) + 1);
                }
            } else {
                for (int bit : getSetBits(nums[left])) {
                    bitCounts.put(bit, bitCounts.get(bit) - 1);
                    if (bitCounts.get(bit) == 0) {
                        bitCounts.remove(bit);
                    }
                }
                left++;
            }

            cur = countsToBitwiseAnd(right - left + 1, bitCounts);

            if (left <= right) {
                bestDiff = Math.min(bestDiff, Math.abs(cur - target));
            }
        }

        return bestDiff;
    }
}