class Solution(object):
    def findPairs(self, nums, k):
        nums = sorted(nums)
        i, j, count = 0, 1, 0
        while i < len(nums)-1:
            j = max(j, i + 1)
            while j < len(nums) and abs(nums[i] - nums[j]) < k:
                j += 1
            if j < len(nums) and abs(nums[i] - nums[j]) == k:
                count += 1
            while i + 1 < len(nums)-1 and nums[i+1] == nums[i]:
                i += 1
            while j + 1 < len(nums) and nums[j+1] == nums[j]:
                j += 1
            i += 1
        return count


print(Solution().findPairs([3, 1, 4, 1, 5], 2))
print(Solution().findPairs([1, 2, 3, 4, 5], 1))
print(Solution().findPairs([1, 3, 1, 5, 4], 0))