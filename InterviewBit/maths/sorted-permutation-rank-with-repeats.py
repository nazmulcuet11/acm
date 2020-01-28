def bigMOD(b, p, MOD):
    if p == 0:
        return 1
    if p == 1:
        return b % MOD

    res = bigMOD(b, int(p / 2), MOD) % MOD
    res = (res * res) % MOD
    if p % 2:
        res = (res * b) % MOD

    return res

class Solution:
    # @param A : string
    # @return an integer
    def findRank(self, A):
        # Calculate Factorials
        MOD = 1000003
        fact = [1]
        for i in range(1, len(A) + 5):
            t = (fact[-1] * i) % MOD
            fact.append(t)
        
        # Create a sorted set for all the characters in A
        count = [0] * 300
        for ch in A:
            count[ord(ch)] += 1 

        MAX_FACT = 1
        for i in range(300):
            if count[i] > 0:
                MAX_FACT = (MAX_FACT * fact[count[i]]) % MOD

        ans = 0
        for index, ch in enumerate(A):
            for i in range(ord(ch)):
                if count[i] > 0:
                    f = fact[len(A)-1-index]
                    t = (MAX_FACT * bigMOD(fact[count[i]], MOD - 2, MOD)) % MOD
                    t = (t * fact[count[i] - 1]) % MOD
                    f = (f * bigMOD(t, MOD - 2, MOD)) % MOD
                    ans += f
                    
            MAX_FACT = (MAX_FACT * bigMOD(fact[count[ord(ch)]], MOD - 2, MOD)) % MOD
            count[ord(ch)] -= 1
            MAX_FACT = (MAX_FACT * fact[count[ord(ch)]]) % MOD

        return (ans + 1) % MOD

print(Solution().findRank('aab'))
print(Solution().findRank('aba'))
print(Solution().findRank('baa'))
print(Solution().findRank('cba'))
print(Solution().findRank('bbbbaaaa'))
print(Solution().findRank('bbbcccaaa'))