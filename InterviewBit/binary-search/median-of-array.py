# Explanation: https://www.youtube.com/watch?v=LPFhl65R7ww

import sys

INT_MAX = sys.maxsize
INT_MIN = -sys.maxsize

def search(X, Y):
    if len(X) > len(Y):
        return search(Y, X)

    l, h = 0, len(X)
    while l <= h:
        partitionX = (l + h) // 2
        partitionY = (len(X) + len(Y) + 1) // 2 - partitionX

        maxLeftX = X[partitionX-1] if partitionX > 0 else INT_MIN
        minRightX = X[partitionX] if partitionX < len(X) else INT_MAX

        maxLeftY = Y[partitionY-1] if partitionY > 0 else INT_MIN
        minRightY = Y[partitionY] if partitionY < len(Y) else INT_MAX

        if maxLeftX <= minRightY and maxLeftY <= minRightX: 
            if (len(X) + len(Y)) % 2:
                return max(maxLeftX, maxLeftY)
            else:
                return (max(maxLeftX, maxLeftY) + min(minRightX, minRightY))/2.0
        if maxLeftX > minRightY:
            h = partitionX - 1
        else:
            l = partitionX + 1
    
class Solution:
    # @param A : tuple of integers
    # @param B : tuple of integers
    # @return a double
    def findMedianSortedArrays(self, A, B):
        return search(A, B)

print(Solution().findMedianSortedArrays([0, 23], []))
print(Solution().findMedianSortedArrays([1, 4, 5], [2, 3]))