class Solution:
    # @param A : list of list of integers
    # @return a list of list of integers
    def diagonal(self, A):
        ans = []
        for i in range(len(A[0])):
            x, y = 0, i
            t = []
            while x < len(A) and y >= 0:
                t.append(A[x][y])
                x += 1
                y -= 1
            ans.append(t)

        for i in range(1, len(A)):
            x, y = i, len(A[0])-1
            t = []
            while x < len(A) and y >= 0:
                t.append(A[x][y])
                x += 1
                y -= 1
            ans.append(t)

        return ans


A = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]

print(Solution().diagonal(A))