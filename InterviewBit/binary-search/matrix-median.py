# Find how many elemnts are lower than x
def lower_bound(A, X):
    l, h = 0, len(A)-1
    while l < h:
        m = l + ((h - l + 1) // 2)
        if A[m] < X:
            l = m
        else:
            h = m - 1
    if A[l] < X:
        return l + 1
    return l

class Solution:
    # @param A : list of list of integers
    # @return an integer
    def findMedian(self, A):
        ROW = len(A)
        COL = len(A[0])

        l = h = A[0][0]
        for i in range(ROW):
            for j in range(COL):
                l = min(A[i][j], l)
                h = max(A[i][j], h)

        median_pos = ((ROW * COL) // 2) + 1
        while l < h:
            m = l + ((h - l) // 2)
            less_than_cnt = 0
            equal_cnt = 0
            for i in range(ROW):
                less_than_cnt += lower_bound(A[i], m)
                equal_cnt += lower_bound(A[i], m+1)

            if less_than_cnt < median_pos and median_pos <= equal_cnt:
                return m
            elif less_than_cnt >= median_pos:
                h = m-1
            else:
                l = m+1
        return l


# print(lower_bound([1, 2, 4], 5))

A = [[1, 3, 5],
     [2, 6, 9],
     [3, 6, 9]]
print(Solution().findMedian(A))

A = [[1]]
print(Solution().findMedian(A))

A = [[1],
     [2],
     [3]]
print(Solution().findMedian(A))

A = [[1, 1, 1, 2, 3]]
print(Solution().findMedian(A))

