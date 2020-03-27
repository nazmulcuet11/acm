class Solution:
    # @param A : list of integers
    # @return A after the sort
    def sortColors(self, A):
        count = [0, 0, 0]
        for c in A:
            count[c] += 1
        return [0] * count[0] + [1] * count[1] + [2] * count[2]