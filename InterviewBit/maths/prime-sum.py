import math
 
class Solution:
    # @param A : integer
    # @return a list of integers
    def primesum(self, A):
        is_prime = [True] * (A+1)
        is_prime[0] = is_prime[1] = False
        i = 2
        while i*i < A+1:
            if is_prime[i]:
                for j in range(i*i, A, i):
                    is_prime[j] = False
            i += 1
 
        for i in range(2, A):
            if is_prime[i] and is_prime[A-i]:
                return [i, A-i]
