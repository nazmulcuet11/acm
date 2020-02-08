def upper_bound(A, X):
    l, h = 0, len(A)-1
    while l < h:
        m = (l + h + 1) // 2
        if A[m] > X:
            h = m-1
        else:
            l = m
    return l if A[l] == X else -1

def lower_bound(A, X):
    l, h = 0, len(A)-1
    while l < h:
        m = (l + h) // 2
        if A[m] < X:
            l = m + 1
        else:
            h = m
    return l if A[l] == X else -1

class Solution:
    # @param A : tuple of integers
    # @param B : integer
    # @return a list of integers
    def searchRange(self, A, B):
        a = lower_bound(A, B)
        b = upper_bound(A, B)
        return [a, b]

print(Solution().searchRange([5, 7, 7, 8, 8, 10], 8))
print(Solution().searchRange([5, 17, 100, 111], 3))