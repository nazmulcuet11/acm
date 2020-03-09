INT_MAX = 2147483647
INT_MIN = -2147483648

class Solution:
    # @param A : string
    # @return an integer
    def atoi(self, A):
        ans = 0
        A = A.lstrip()
        sign = None
        for ch in A:
            if ch.isnumeric():
                ans = ans * 10 + int(ch)
                if (not sign or sign == '+') and ans >= INT_MAX:
                    return INT_MAX
                if sign == '-' and -ans <= INT_MIN:
                    return INT_MIN
            elif sign == None and (ch == '+' or ch == '-'):
                sign = ch
            else:
                break
        
        if sign == '-':
            return -ans
        return ans

print(Solution().atoi("    #9 2704"))
print(Solution().atoi("-7"))