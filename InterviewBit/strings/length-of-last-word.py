class Solution:
    # @param A : string
    # @return an integer
    def lengthOfLastWord(self, A):
        words = A.split()
        if len(words) == 0:
            return 0
        return len(words[-1])

print(Solution().lengthOfLastWord("Hello world"))
print(Solution().lengthOfLastWord("       "))
print(Solution().lengthOfLastWord("world"))