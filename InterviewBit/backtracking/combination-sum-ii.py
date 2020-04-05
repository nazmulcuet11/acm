combinations, comb = [], []
arr = []

def combination_sum(i, sum):
    global combinations, comb, arr
    if i == len(arr):
        if sum == 0:
            combinations.append(comb.copy())
        return 
    
    if sum - arr[i] >= 0:
        comb.append(arr[i])
        combination_sum(i + 1, sum - arr[i])
        comb.pop()
    combination_sum(i + 1, sum)

class Solution:
    # @param A : list of integers
    # @param B : integer
    # @return a list of list of integers
    def combinationSum(self, A, B):
        global combinations, comb, arr
        combinations = []
        comb = []
        arr = sorted(A)
        combination_sum(0, B)

        combinations.sort()
        unique_combinations = []
        seen_combinations = {}
        for comb in combinations:
            key = tuple(comb)
            if key not in seen_combinations:
                seen_combinations[key] = True
                unique_combinations.append(comb)

        return unique_combinations


print(Solution().combinationSum([2, 3, 6, 7], 7))
print(Solution().combinationSum([1, 1, 1, 1], 4))
print(Solution().combinationSum([10, 1, 2, 7, 6, 1, 5], 8))
