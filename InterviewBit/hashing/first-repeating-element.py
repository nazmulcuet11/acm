class Solution:
    # @param A : list of integers
    # @return an integer
    def solve(self, A):
        hash = {}
        min_idx = len(A)
        for idx, v in enumerate(A):
            if v in hash:
                min_idx = min(min_idx, hash[v])
            else:
                hash[v] = idx

        if min_idx == len(A):
            return -1
        return A[min_idx]
