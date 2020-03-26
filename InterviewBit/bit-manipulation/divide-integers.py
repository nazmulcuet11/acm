INT_MAX = 2**31 - 1
INT_MIN = -2**31

def divide_bitwise(dividend, divisor):
    sign = -1 if (dividend < 0) ^ (divisor < 0) else 1
    dividend = abs(dividend)
    divisor = abs(divisor)

    temp, quotient = 0, 0
    for i in range(31, -1, -1):
        if temp + (divisor << i) <= dividend:
            temp += divisor << i
            quotient |= (1 << i)
    
    quotient *= sign

    if quotient > INT_MAX:
        return INT_MAX
    
    if quotient < INT_MIN:
        return INT_MIN

    return quotient


class Solution:
    # @param A : integer
    # @param B : integer
    # @return an integer
    def divide(self, A, B):
        return divide_bitwise(A, B)


print(Solution().divide(-2147483648, 1))
print(Solution().divide(-2147483648, -1))
print(Solution().divide(2147483648, 1))
print(Solution().divide(2147483648, -1))