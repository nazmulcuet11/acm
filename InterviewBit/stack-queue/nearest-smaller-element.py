class Solution:
    # @param A : list of integers
    # @return a list of integers
    def prevSmaller(self, a):
        stack = []
        for i, n in enumerate(a):
            while len(stack) > 0 and stack[-1] >= n:
                stack.pop()
            a[i] = -1 if len(stack) == 0 else stack[-1]
            stack.append(n)
        return a

print(Solution().prevSmaller([4, 5, 2, 10, 8]))