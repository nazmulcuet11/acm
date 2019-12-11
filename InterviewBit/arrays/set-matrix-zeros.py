class Solution:
    # @param A : list of list of integers
    # @return the same list modified
    def setZeroes(self, A):
        rows = [1]*len(A)
        cols = [1]*len(A[0])

        for i in range(len(A)):
            for j in range(len(A[0])):
                if A[i][j] == 0:
                    rows[i] = 0
                    cols[j] = 0

        for i in range(len(rows)):
            if rows[i] == 0:
                for j in range(len(A[0])):
                    A[i][j] = 0

        for j in range(len(cols)):
            if cols[j] == 0:
                for i in range(len(A)):
                    A[i][j] = 0

        return A


print(Solution().setZeroes([
    [0, 1],
    [1, 1]
]))