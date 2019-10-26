class Solution:
    # @param A : integer
    # @return a list of list of integers
    def solve(self, A):
        ans = []
        for i in range(A):
            t = []
            for j in range(i+1):
                x = ans[i-1][j] if i - 1 >= 0 and j < len(ans[i-1]) else 0
                y = ans[i-1][j-1] if i - 1 >= 0 and j - 1 >= 0  else 0
                t.append(max(x + y, 1))
            ans.append(t)
        
        return ans

print(Solution().solve(5))