class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return an integer
    def solve(self, A, B):
        i, j = 0, len(A)-1
        cnt = 0
        while i < j:
            sum = A[i] + A[j]
            if sum == B:
                cnt += 1
            if sum > B:
                j -= 1
            else:
                i += 1
        return cnt
