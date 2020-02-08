class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return an integer
    def searchInsert(self, A, B):
        l, h = 0, len(A)-1
        while l < h:
            m = (l + h) // 2
            if A[m] == B:
                return m
            if A[m] > B:
                h = m-1
            else:
                l = m+1

        if A[l] < B:
            return l + 1
        return l


print(Solution().searchInsert([1,3,5,6], 5))
print(Solution().searchInsert([1,3,5,6], 2))
print(Solution().searchInsert([1,3,5,6], 7))
print(Solution().searchInsert([1,3,5,6], 0))