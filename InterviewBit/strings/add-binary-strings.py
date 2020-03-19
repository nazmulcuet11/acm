def add(a, b):
    a = a[::-1]
    b = b[::-1]
    while len(a) < len(b):
        a += '0'
    while len(b) < len(a):
        b += '0'

    ans = ""
    carry = 0
    for i in range(len(a)):
        int_sum = int(a[i]) + int(b[i]) + carry
        ans += str(int_sum % 2)
        carry = int_sum // 2
    
    if carry > 0:
        ans += str(carry)

    return ans[::-1]

class Solution:
    # @param A : string
    # @param B : string
    # @return a strings
    def addBinary(self, A, B):
        return add(A, B)

print(Solution().addBinary("100", "11"))