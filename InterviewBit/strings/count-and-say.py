class Solution:
    # @param A : integer
    # @return a strings
    def countAndSay(self, A):
        s = '1'
        while A-1:
            c = ''
            cnt = 1
            for i in range(1, len(s)+1):
                if i < len(s) and s[i] == s[i-1]:
                    cnt += 1
                if i == len(s) or s[i] != s[i-1]:
                    c += str(cnt)
                    c += s[i-1]
                    cnt = 1
            s = c
            A -= 1
        return s

print(Solution().countAndSay(1))
print(Solution().countAndSay(2))
print(Solution().countAndSay(3))
print(Solution().countAndSay(4))
print(Solution().countAndSay(5))
print(Solution().countAndSay(6))
print(Solution().countAndSay(7))
print(Solution().countAndSay(8))
print(Solution().countAndSay(9))
