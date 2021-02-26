class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return an integer
    def solve(self, A, B):
        hash = {0: 1}
        odd_count, ans = 0, 0
        for v in A:
            if v % 2 == 1:
                odd_count += 1
            t = odd_count - B
            ans += hash.get(t, 0)
            hash[odd_count] = hash.get(odd_count, 0) + 1
        return ans


print(Solution().solve([4, 3, 2, 3, 4], 2))
print(Solution().solve([5, 6, 7, 8, 9], 3))
