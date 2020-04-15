digit_map = [
    "0",
    "1",
    "abc",
    "def",
    "ghi",
    "jkl",
    "mno",
    "pqrs",
    "tuv",
    "wxyz"
]

comb = []
digit_str = ""
solutions = []

def solve(i):
    global comb, digit_str, digit_map, solutions

    if i >= len(digit_str):
        s = ''.join(comb)
        solutions.append(s)
        return

    mapped_values = digit_map[int(digit_str[i])]
    for val in mapped_values:
        comb.append(val)
        solve(i + 1)
        comb.pop()

class Solution:
    # @param A : string
    # @return a list of strings
    def letterCombinations(self, A):
        global comb, digit_str, solutions
        solutions = []
        comb = []
        digit_str = A
        solve(0)
        return sorted(solutions)


print(Solution().letterCombinations("23"))