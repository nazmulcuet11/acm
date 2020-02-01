class Solution:
    # @param A : integer
    # @param B : integer
    # @return an integer
    def uniquePaths(self, A, B):
        ways = [[0]*B for _ in range(A)]
        for i in range(A):
            ways[i][0] = 1
        for i in range(B):
            ways[0][i] = 1

        for i in range(1, A):
            for j in range(1, B):
                ways[i][j] = ways[i-1][j] + ways[i][j-1]

        return ways[A-1][B-1]


print(Solution().uniquePaths(2, 2))