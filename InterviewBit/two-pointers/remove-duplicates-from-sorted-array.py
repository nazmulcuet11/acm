class Solution:
    # @param A : list of integers
    # @return an integer
    def removeDuplicates(self, A):
        i, j = 0, 0
        while j < len(A):
            while j + 1 < len(A) and A[j+1] == A[j]:
                j += 1
            A[i] = A[j]
            i += 1
            j += 1

        return i