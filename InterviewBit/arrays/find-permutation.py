class Solution:
    # @param A : string
    # @param B : integer
    # @return a list of integers
    def findPerm(self, A, B):
        x = 1
        ans = []
        for char in A:
            if char == 'I':
                ans.append(x)
                x += 1
            else:
                ans.append(B)
                B -= 1
        ans.append(x)
        return ans

print(Solution().findPerm("ID", 3))
print(Solution().findPerm("IIDDIIIDD", 10))