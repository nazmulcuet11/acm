# import resource, sys
# resource.setrlimit(resource.RLIMIT_STACK, (2**29,-1))
# sys.setrecursionlimit(10**6)

def isPalin(S):
    i, j = 0, len(S)-1
    while i < j:
        if S[i] != S[j]:
            return 0
        i += 1
        j -= 1

    return 1

class Solution:
    # @param A : string
    # @return an integer
    def isPalindrome(self, A):
        A = A.lower()
        s = ""
        for ch in A:
            if ch.isalnum():
                s += ch

        return isPalin(s)


print(Solution().isPalindrome("A man, a plan, a canal: Panama"))
print(Solution().isPalindrome(""))