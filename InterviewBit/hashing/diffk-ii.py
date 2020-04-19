class Solution:
    # @param A : tuple of integers
    # @param B : integer
    # @return an integer
    def diffPossible(self, a, target):
        seen = {}
        for i in range(len(a)):
            diff = target + a[i]
            if diff in seen:
                return 1
            diff = a[i] - target
            if diff in seen:
                return 1
            seen[a[i]] = True
        return 0

print(Solution().diffPossible([11, 85, 100, 44, 3, 32, 96, 72, 93, 76, 67, 93, 63, 5, 10, 45, 99, 35, 13], 60))