import heapq

class Solution:
    # @param A : integer
    # @param B : list of integers
    # @return an integer
    def nchoc(self, k, a):
        MOD = 10**9+7

        for i in range(len(a)):
            a[i] *= -1
        heapq.heapify(a)
        sum = 0
        for i in range(k):
            if len(a) <= 0:
                break
            
            t = -heapq.heappop(a)
            sum = (sum + t) % MOD

            t //= 2
            if t > 0:
                heapq.heappush(a, -t)
        return sum % MOD

print(Solution().nchoc(3, [6, 5]))
