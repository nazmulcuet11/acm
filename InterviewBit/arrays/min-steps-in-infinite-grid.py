# lets assume we are going to (x, y) from (0, 0)
# we want to travel minimum distance so we will
# try to go diagonally, we can move diagonally
# upto t = min(x, y) steps, after we reach (t, t)
# we have to max(x, y) - t steps sidewise. So we
# have to travel max(x, y) - t + t = max(x, y)
# distance in total.
#
# So we can say to reach (x2, y2) from (x1, y1)
# we must move max(abs(x2-x1), abs(y2-y1)) steps atleast.

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
