class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return a list of integers
    def solve(self, A, B):
        return sorted(A, reverse=True)[:B]


print(Solution().solve([11, 3, 4], 2))
print(Solution().solve([11, 3, 4, 6], 3))
