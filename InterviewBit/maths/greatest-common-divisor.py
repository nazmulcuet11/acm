def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a

class Solution:
    # @param A : integer
    # @param B : integer
    # @return an integer
    def gcd(self, A, B):
        return gcd(A, B)

