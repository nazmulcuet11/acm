class Solution:
    # @param A : list of integers
    # @return an integer
    def findMinXor(self, A):
        A = sorted(A)
        mn = A[-1]
        for i in range(1, len(A)):
            mn = min(mn, A[i] ^ A[i-1])
        return mn

