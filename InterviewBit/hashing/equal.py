class Solution:
    # @param A : list of integers
    # @return a list of integers
    def equal(self, a):
        seen = {}
        ans = []
        for i in range(len(a)):
            for j in range(i + 1, len(a)):
                t = a[i] + a[j]
                if t in seen:
                    x, y = seen[t]
                    if x >= i or y == i or y == j:
                        continue
                    s = [x, y, i, j]
                    if ans == [] or s < ans:
                        ans = s
                seen[t] = (i, j)

        return ans

print(Solution().equal([1, 1, 1, 1, 1]))