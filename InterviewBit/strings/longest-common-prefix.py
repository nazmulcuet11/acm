class Solution:
    # @param A : list of strings
    # @return a strings
    def longestCommonPrefix(self, A):
        x = 0
        while x < len(A[0]):
            for i in range(1, len(A)):
                if x >= len(A[i-1]) or x >= len(A[i]) or A[i-1][x] != A[i][x]:
                    return A[0][0:x]
            x += 1
        return A[0][0:x]

print(Solution().longestCommonPrefix(["abcd"]))
print(Solution().longestCommonPrefix(["abcdefgh", "aefghijk", "abcefgh"]))
print(Solution().longestCommonPrefix(["abab", "ab", "abcd"]))

