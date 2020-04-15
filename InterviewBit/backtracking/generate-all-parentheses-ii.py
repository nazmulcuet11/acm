
solutions = []
comb = []
def solve(open_used, close_used, total):
    global comb, solutions

    if close_used >= total:
        t = ''.join(comb)
        solutions.append(t)
        return

    if open_used < total:
        comb.append('(')
        solve(open_used + 1, close_used, total)
        comb.pop()
    if close_used < open_used:
        comb.append(')')
        solve(open_used, close_used + 1, total)
        comb.pop()

class Solution:
    # @param A : integer
    # @return a list of strings
    def generateParenthesis(self, A):
        global comb, solutions
        solutions = []
        comb = []
        solve(0, 0, A)
        return sorted(solutions)

print(Solution().generateParenthesis(3))