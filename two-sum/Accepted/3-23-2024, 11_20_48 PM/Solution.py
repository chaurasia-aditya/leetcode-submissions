// https://leetcode.com/problems/two-sum

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        map = {}

        for i, num in enumerate(nums):
            if target-num in map:
                return [i, map[target-num]]
            map[num] = i

        return []
        