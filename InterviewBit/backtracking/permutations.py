

all_permutations = []
permutation = []
taken = []
numbers = []

def reset_globals(nums):
    global all_permutations, permutation, taken, numbers 
    all_permutations = []
    permutation = []
    taken = [False] * len(nums)
    numbers = nums

def generate_permutions():
    global all_permutations, permutation, taken, numbers

    if len(permutation) >= len(numbers):
        all_permutations.append(permutation.copy())
        return

    for i in range(len(numbers)):
        if taken[i]:
            continue
        taken[i] = True
        permutation.append(numbers[i])
        generate_permutions()
        permutation.pop()
        taken[i] = False

class Solution:
    # @param A : list of integers
    # @return a list of list of integers
    def permute(self, A):
        reset_globals(A)
        generate_permutions()
        return all_permutations

print(Solution().permute([1, 2, 3]))