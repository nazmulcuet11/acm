## Problem Description
There are `A` cities numbered from 1 to `A`. You have already visited `M` cities, the indices of which are given in an array `B` of `M` integers.
If a city with index `i` is visited, you can visit either the city with index `i-1 (i >= 2)` or the city with index `i+1 (i < A)` if they are not already visited.
Eg: if `N = 5` and array `M` consists of `[3, 4]`, then in the first level of moves, you can either visit `2` or `5`.
You keep visiting cities in this fashion until all the cities are not visited.

Link: https://www.interviewbit.com/problems/city-tour/

## Solution Approach:
This question uses the concept of combinatorics. We can see vector `B` as ranges to be arranged, but we also have to select the order in which the elements of a single group are chosen within themselves.

Suppose we have a single group `G1` consisting `N` numbers, so this group can be permuted in 2<sup>N-1</sup> ways(as we can take from either side of the group and keep choosing until there is only one number left). Obviously the left most and right most group can be arranged among themselves in only one possible way.

Now consider another group `G2` of `M` numbers. Now we have `N + M` places to place numbers of `G2` or `G1`. So we can choose `M` places for `G2` in <sup>N+M</sup>C<sub>M</sub> ways(or we can choose `N` places for `G1` in <sup>N+M</sup>C<sub>N</sub> ways, both will be the same). And we can arrange numbers of `G2` in 2<sup>M-1</sup> ways. Thus we have `N` places left for numbers of `G1`, so we can place them in 2<sup>N-1</sup> x <sup>N</sup>C<sub>N</sub> ways. 

So we have 2<sup>N-1</sup> x <sup>N</sup>C<sub>N</sub> x 2<sup>M-1</sup> x <sup>N+M</sup>C<sub>M</sub> ways for numbers of `G1` and `G2` combined.

Can we see a pattern??? :mag_right:

Complete Solution:
```python
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
    
```