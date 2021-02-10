import heapq as hq


class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return an integer
    def solve(self, A, B):
        A = [x * -1 for x in A]
        hq.heapify(A)
        ans = 0
        while B > 0 and len(A) > 0:
            t = hq.heappop(A)
            ans += (-t)
            hq.heappush(A, t + 1)
            B -= 1
        return ans


print(Solution().solve([2, 3], 3))
print(Solution().solve([1, 4], 2))
