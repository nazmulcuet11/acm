class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return a list of integers
    def maxone(self, A, B):
        zero_count = 0
        i, j = 0, 0
        max_window_size = 0
        x, y = -1, -1
        while i < len(A) and j < len(A):
            t = A[j] ^ 1
            if zero_count + t <= B:
                zero_count += t
                j += 1
            else:
                if A[i] == 0:
                    zero_count -= 1
                i += 1

            window_size = j - i
            if window_size > max_window_size:
                x, y = i, j
                max_window_size = window_size
        
        indices = []
        for i in range(x, y):
            indices.append(i)

        return indices

print(Solution().maxone([1, 1, 0, 1, 1, 0, 0, 1, 1, 1], 1))