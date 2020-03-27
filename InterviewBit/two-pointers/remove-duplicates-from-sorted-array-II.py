class Solution:
    # @param A : list of integers
    # @return an integer
    def removeDuplicates(self, A):
        i, j = 0, 0
        while j < len(A):
            if j + 2 < len(A) and A[j + 2] == A[j]:
                j += 1
            else:
                A[i] = A[j]
                i += 1
                j += 1
        return i

print(Solution().removeDuplicates([1, 1, 1, 2]))