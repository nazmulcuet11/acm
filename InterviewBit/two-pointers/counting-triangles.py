MOD = 10**9 + 7

def get_count(numbers, target):
    l, h = 0, len(numbers) - 1
    while l < h:
        m = (l + h + 1) // 2
        if numbers[m] >= target:
            h = m - 1
        else:
            l = m
    if numbers[l] >= target:
        return l
    return l + 1

class Solution:
    # @param A : list of integers
    # @return an integer
    def nTriang(self, A):
        A = sorted(A)
        ans = 0
        for i in range(len(A)-2):
            if A[i] == 0:
                continue
            k = i + 2
            for j in range(i + 1, len(A)-1):
                while k < len(A) and A[i] + A[j] > A[k]:
                    k += 1
                ans += k - j - 1
                ans %= MOD
        return ans % MOD

print(Solution().nTriang([1, 1, 1]))
print(Solution().nTriang([1, 1, 1, 2, 2]))
print(Solution().nTriang([ 4, 6, 13, 16, 20, 3, 1, 12]))



