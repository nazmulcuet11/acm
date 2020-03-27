class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return an integer
    def removeElement(self, A, B):
        i, j = 0, 0
        while j < len(A):
            if A[j] == B:
                j += 1
            else:
                A[i] = A[j]
                i += 1
                j += 1
        return i

print(Solution().removeElement([4, 1, 1, 2, 1, 3], 1))
