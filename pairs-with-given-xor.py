class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return an integer
    def solve(self, A, B):
        hash = {}
        for v in A:
            hash[v] = 1

        count = 0
        for k in hash:
            t = k ^ B
            if t in hash:
                count += 1

        return count // 2


print(Solution().solve([5, 4, 10, 15, 7, 6], 5))
print(Solution().solve([3, 6, 8, 10, 15, 50], 5))
