class Solution:
    # @param A : list of integers
    # @return an integer
    def maxArea(self, A):
        i, j = 0, len(A) - 1
        max_area = 0
        while i < j:
            area = min(A[i], A[j]) * (j - i)
            max_area = max(max_area, area)

            if A[i] <= A[j]:
                i += 1
            else:
                j -= 1

        return max_area

print(Solution().maxArea([1, 5, 4, 3]))