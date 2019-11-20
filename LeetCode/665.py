class Solution:
    def __check(self, nums):
        for i in range(len(nums) - 1):
            if nums[i] > nums[i+1]:
                return False
        return True

    def checkPossibility(self, nums) -> bool:
        n = len(nums)
        if n < 3:
            return True

        if nums[0] > nums[1]:
            nums[0] = nums[1]
            return self.__check(nums)
        
        if nums[n-1] < nums[n-2]:
            nums[n-1] = nums[n-2]
            return self.__check(nums) 

        for i in range(1, n-1):
            if nums[i-1] <= nums[i+1] and (nums[i] < nums[i-1] or nums[i] > nums[i+1]):
                nums[i] = nums[i+1]
                break
        return self.__check(nums)
            
        

print(Solution().checkPossibility([-1, 4, 2, 3]))
print(Solution().checkPossibility([4, 2, 3]))
print(Solution().checkPossibility([4, 2, 1]))
print(Solution().checkPossibility([2, 3, 3, 2, 4]))