class Solution(object):
    def productExceptSelf(self, nums):
        copy = nums.copy() + [1]
        for i in range(len(nums)-1, -1, -1):
            copy[i] *= copy[i + 1]

        product, ans = 1, []
        for i in range(len(nums)):
            ans.append(product * copy[i+1])
            product *= nums[i]

        return ans

ans = Solution().productExceptSelf([1, 2, 3, 4])
# ans = Solution().productExceptSelf([0, 0])
print(ans)