MOD = 10003
vowels = ['a', 'e', 'i', 'o', 'u']

class Solution:
    # @param A : string
    # @return an integer
    def solve(self, s):
        n = len(s)
        cnt = 0
        for i in range(n):
            ch = s[i].lower()
            if ch in vowels:
                cnt = (cnt + n-i) % MOD
        return cnt

print(Solution().solve("ABEC"))



