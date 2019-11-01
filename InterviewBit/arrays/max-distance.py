class Solution:
    # @param A : tuple of integers
    # @return an integer
    def maximumGap(self, A):
        x = list(map(lambda x: x[1], sorted([(A[i], i) for i in range(len(A))])))
        minIndex, ans = 999999, 0
        for e in x:
            ans = max(ans, e - minIndex)
            minIndex = min(minIndex, e)
        return ans


print(Solution().maximumGap([3, 5, 4, 2]))