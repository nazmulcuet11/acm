def is_attacking(columns, r, c):
    if columns[c] != -1:
        return True
    for col, row in enumerate(columns):
        if row == -1:
            continue
        if row - col == r - c or row + col == r + c:
            return True
    return False

def valid_solution(columns):
    n = len(columns)
    for v in columns:
        if v < 0 or v >= n:
            return False
    return True

solutions = []
def add_solution(columns):
    global solutions    
    n = len(columns)
    s = [(['.'] * n) for _ in range(n)]
    for c, r in enumerate(columns):
        s[r][c] = 'Q'
    t = []
    for i in range(n):
        t.append(''.join(s[i]))
    solutions.append(t)

def nqueen(r, columns):
    if r < 0:
        if valid_solution(columns):
            add_solution(columns)
        return
    
    for c in range(len(columns)):
        if not is_attacking(columns, r, c):
            columns[c] = r 
            nqueen(r - 1, columns)
            columns[c] = -1
        

class Solution:
    # @param A : integer
    # @return a list of list of strings
    def solveNQueens(self, A):
        global solutions
        columns = [-1] * A
        solutions = []
        nqueen(A-1, columns)
        return solutions


print(Solution().solveNQueens(4))