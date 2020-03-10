class Solution:
    # @param A : string
    # @return a strings
    def solve(self, A):
        words = A.split()
        words = words[::-1]
        return ' '.join(words)

print(Solution().solve(""))