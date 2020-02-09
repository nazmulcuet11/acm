import resource, sys
# resource.setrlimit(resource.RLIMIT_STACK, (2**29,-1))
sys.setrecursionlimit(10**6)

def power(b, p, MOD):
    if p == 0:
        return 1
    if p == 1:
        return (b + MOD) % MOD

    ret = power(b, p//2, MOD)
    ret = (ret * ret) % MOD
    if p % 2:
        ret = (ret * b) % MOD
    return (ret + MOD) % MOD

class Solution:
    # @param x : integer
    # @param n : integer
    # @param d : integer
    # @return an integer
    def pow(self, x, n, d):
        if x == 0:
            return 0
        return power(x, n, d)

print(Solution().pow(2, 3, 3))
print(Solution().pow(0, 0, 1))
print(Solution().pow(-1, 1, 20))