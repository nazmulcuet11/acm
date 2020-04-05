combinations, comb = [], []
N, K = -1, -1

def generate_combinations(i):
    global combinations, comb, N, K
    if len(comb) == K:
        combinations.append(comb.copy())
        return 
    
    for j in range(i, N + 1):
        comb.append(j)
        generate_combinations(j + 1)
        comb.pop()


class Solution:
    # @param A : integer
    # @param B : integer
    # @return a list of list of integers
    def combine(self, A, B):
        global combinations, comb, N, K
        combinations = []
        comb = []
        N = A
        K = B
        generate_combinations(1)
        return combinations

print(Solution().combine(4, 2))

