def search(A, B):
    l, h = 0, len(A)*len(A[0])-1
    while l < h:
        m = (l + h) // 2
        i = m // len(A[0])
        j = m % len(A[0])
        if A[i][j] == B:
            return 1
        if A[i][j] > B:
            h = m-1
        else:
            l = m+1
    i = l // len(A[0])
    j = l % len(A[0])
    return 1 if A[i][j] == B else 0

class Solution:
    # @param A : list of list of integers
    # @param B : integer
    # @return an integer
    def searchMatrix(self, A, B):
        return search(A, B)

A = [[1,   3,  5,  7],
     [10, 11, 16, 20],
     [23, 30, 34, 50]]
print(Solution().searchMatrix(A, 3))

A = [[5, 17, 100, 111],
     [119, 120, 127, 131]]
print(Solution().searchMatrix(A, 3))

