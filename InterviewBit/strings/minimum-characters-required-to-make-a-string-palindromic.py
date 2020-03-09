lps = []
def calculate_lps(pattern):
    global lps
    lps = [0]
    for i in range(1, len(pattern)):
        j = lps[i-1]
        while j > 0 and pattern[j] != pattern[i]:
            j = lps[j-1]
        if pattern[j] == pattern[i]:
            lps.append(j + 1)
        else:
            lps.append(0)

class Solution:
    # @param A : string
    # @return an integer
    def solve(self, A):
        calculate_lps(A + '#' + A[::-1])
        return len(A) - lps[-1]


"""
def isPalindrome(s, i, j):
    while i < j:
        if s[i] != s[j]:
            return False
        i += 1
        j -= 1
    return True

class Solution:
    # @param A : string
    # @return an integer
    def solve(self, A):
        for i in range(len(A), 0, -1):
            if isPalindrome(A, 0, i-1):
                return len(A) - i
    
"""