class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return an integer
    def solve(self, A, B):
        hash = {0: 1}
        xor, cnt, ans = 0, 0, 0
        for idx, v in enumerate(A):
            xor ^= v
            ans += hash.get(xor ^ B, 0)
            hash[xor] = hash.get(xor, 0) + 1

        return ans


print(Solution().solve([4, 2, 2, 6, 4], 6))
print(Solution().solve([5, 6, 7, 8, 9], 5))
