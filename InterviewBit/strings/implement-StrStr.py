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

def kmp_serch(s, p):
    calculate_lps(p)
    i, j = 0, 0
    while i < len(s):
        if s[i] == p[j]:
            i += 1
            j += 1
        else:
            if j == 0:
                i += 1
            else:
                j = lps[j-1]

        if j == len(p):
            return i - len(p)

    return -1

class Solution:
    # @param A : string
    # @param B : string
    # @return an integer
    def strStr(self, A, B):
        if not A or not B:
            return -1
        
        return kmp_serch(A, B)