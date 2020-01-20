def getNumber(c):
    return ord(c) - ord('A') + 1

class Solution:
    # @param A : string
    # @return an integer
    def titleToNumber(self, A):
        ans = 0
        for i in range(len(A)):
            ans = ans * 26 + getNumber(A[i])
        return ans

print(Solution().titleToNumber('A'))
print(Solution().titleToNumber('B'))
print(Solution().titleToNumber('C'))
print(Solution().titleToNumber('AA'))
print(Solution().titleToNumber('BBA'))