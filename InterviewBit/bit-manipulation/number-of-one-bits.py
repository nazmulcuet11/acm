def count_set_bit(n):
    cnt = 0
    while n > 0:
        if (n & 1) > 0:
            cnt += 1
        n >>= 1
    return cnt

class Solution:
    # @param A : integer
    # @return an integer
    def numSetBits(self, A):
        return count_set_bit(A)