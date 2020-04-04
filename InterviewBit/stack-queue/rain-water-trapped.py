class Solution:
    # @param A : tuple of integers
    # @return an integer
    def trap(self, A):
        max_on_right = [0] * len(A)
        for i in range(len(A)-2, -1, -1):
            max_on_right[i] = max(max_on_right[i+1], A[i+1])
        max_on_left = 0
        total_water = 0
        for i in range(len(A)):
            min_height = min(max_on_left, max_on_right[i])
            water = min_height - A[i]
            if water > 0:
                total_water += water
            max_on_left = max(max_on_left, A[i])
        return total_water

print(Solution().trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]))