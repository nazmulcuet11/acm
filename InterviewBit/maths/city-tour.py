MOD = int(1e9 + 7)
MAX_N = 1000 + 5
# following creates an unexpected problem, reference of inner array is copied
# comb = [[0]*MAX_N]*MAX_N
comb = [[0]*MAX_N for _ in range(MAX_N)]
for n in range(MAX_N):
    comb[n][0] = 1

for n in range(1, MAX_N):
    for r in range(1, n+1):
        comb[n][r] = (comb[n-1][r] + comb[n-1][r-1]) % MOD

powers_of_two = [1]
for i in range(1, MAX_N):
    powers_of_two.append((powers_of_two[-1]*2) % MOD)

class Solution:
    # @param A : integer
    # @param B : list of integers
    # @return an integer
    def solve(self, A, B):
        B.sort()
        ans, current_total = 1, 0
        # Calculate for the first range, it's numbers can be ordered among themselves in only one way  
        if B[0] > 1:
            current_total += B[0] - 1

        for i in range(1, len(B)):
            diff = B[i] - B[i-1] - 1
            current_total += diff
            if diff > 0:
                ans = (ans * powers_of_two[diff-1]) % MOD
            ans = (ans * comb[current_total][diff]) % MOD

        # Calculate for the first range, it's numbers can be ordered among themselves in only one way
        # But we can take diff = B - A[-1] from current_total+diff in (current_total+diff)C(diff) ways
        if B[-1] < A:
            diff = A - B[-1]
            current_total += diff 
            ans = (ans * comb[current_total][diff]) % MOD

        return ans
    
print(Solution().solve(5, [5, 2]))