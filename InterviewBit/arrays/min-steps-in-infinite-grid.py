class Solution:
    # @param A : list of integers
    # @param B : list of integers
    # @return an integer
    def coverPoints(self, A, B):
        sum = 0
        for i in range(1, len(A)):
            sum += max(abs(A[i]-A[i-1]), abs(B[i] - B[i-1]))
        return sum

# sum = Solution().coverPoints([0, 1, 1], [0, 1, 2])
sum = Solution().coverPoints([-7, -13], [1, -5])
print(sum)