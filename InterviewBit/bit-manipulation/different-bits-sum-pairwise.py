class Solution:
    # @param A : list of integers
    # @return an integer
    def cntBits(self, A):
        bit_counts = [0] * 32
        for number in A:
            i = 0
            while number > 0:
                if number & 1 > 0:
                    bit_counts[i] += 1
                number >>= 1
                i += 1

        MOD = 10**9 + 7
        ans = 0
        for i in range(32):
            ans += (len(A) - bit_counts[i]) * bit_counts[i] * 2
            ans %= MOD

        return ans

print(Solution().cntBits([1, 3, 5]))