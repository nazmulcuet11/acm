class Solution:
    # @param A : string
    # @return an integer
    def findRank(self, A):
        # Calculate Factorials
        MOD = 1000003
        fact = [1]
        for i in range(1, 300):
            t = (fact[-1] * i) % MOD
            fact.append(t)
        
        # Create a sorted set for all the characters in A
        count = [0] * 300
        for ch in A:
            count[ord(ch)] += 1 

        ans = 0
        for index, ch in enumerate(A):
            current_order = 0
            for j in range(ord(ch)):
                current_order += count[j]
            count[ord(ch)] -= 1 
            f = fact[len(A)-1-index]
            ans = (ans + (current_order * f) % MOD) % MOD

        return (ans + 1) % MOD

print(Solution().findRank('abc'))
print(Solution().findRank('acb'))
print(Solution().findRank('cab'))
print(Solution().findRank('cba'))