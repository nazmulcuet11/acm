class Solution:
    # @param A : tuple of integers
    # @return an integer
    def getBits(self, n, size=32):
        bits = []
        for i in range(size):
            bits.append((n >> i) & 1)
        return bits

    def hammingDistance(self, A):
        counter = [0]*32
        for number in A:
            bits = self.getBits(number)
            for i in range(32):
                counter[i] += bits[i]

        ans = 0
        for i in range(32):
            ans += counter[i] * (len(A) - counter[i])

        return (2*ans)%1000000007

print(Solution().hammingDistance([2, 7]))
print(Solution().hammingDistance([2, 4, 6]))