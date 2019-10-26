class Solution:
    # @param A : list of integers
    # @return a list of integers
    def maxset(self, A):
        x, y, = 0, 0
        mx, sum = 0, 0
        j = -1
        for i in range(len(A)):
            if A[i] >= 0:
                sum += A[i]
                if sum > mx or (sum == mx and i - j > x - y):
                    x, y = i, j
                    mx = sum
            else:
                sum = 0
                j = i
        return A[y+1:x+1]


print(Solution().maxset([1, 2, 5, -7, 2, 3]))
print(Solution().maxset([10, -1, 2, 3, -4, 100]))

