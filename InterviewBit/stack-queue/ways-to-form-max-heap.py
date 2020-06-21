import math

MOD = 1000000007
SIZE = 100 + 5
ncr = [[0 for _ in range(SIZE)] for _ in range(SIZE)]


def calculate_nCr():
    global ncr
    for n in range(SIZE):
        ncr[n][0] = 1
    for n in range(1, SIZE):
        for r in range(1, n+1):
            ncr[n][r] = (ncr[n-1][r] + ncr[n-1][r-1]) % MOD


class Solution:
    def __init__(self):
        calculate_nCr()

    # @param A : integer
    # @return an integer
    def solve(self, n):
        if n == 0:
            return 1
        # print(n)
        h = int(math.log(n, 2))
        # Max Possible number of element at height h
        max_possible_at_h = 2**h
        total_elemement_below_h = max_possible_at_h - 1
        actual_at_h = n - total_elemement_below_h
        total_at_left_tree = int((total_elemement_below_h - 1) / 2)
        total_at_left_tree += int(min(actual_at_h, max_possible_at_h / 2))
        total_at_right_tree = n - 1 - total_at_left_tree
        total = ncr[n-1][total_at_left_tree] * \
            self.solve(total_at_left_tree)*self.solve(total_at_right_tree)

        return total % MOD


print(Solution().solve(4))
