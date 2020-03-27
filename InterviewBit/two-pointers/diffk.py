class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return an integer
    def diffPossible(self, numbers, k):
        j = 1
        for i in range(len(numbers)-1):
            j = max(j, i + 1)
            while j < len(numbers) and abs(numbers[i] - numbers[j]) < k:
                j += 1
            if j < len(numbers) and abs(numbers[i] - numbers[j]) == k:
                return 1
        return 0

# print(Solution().diffPossible([1, 3, 5], 4))
# print(Solution().diffPossible([2, 14, 18, 23, 25, 36, 40, 44, 44, 53, 54, 68, 71, 80, 94], 82))
print(Solution().diffPossible([1, 2, 3], 0))