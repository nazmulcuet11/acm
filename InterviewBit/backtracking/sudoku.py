board = [([0] * 9) for _ in range(9)]
open_positions = []
solved_board = []

def reset_globals():
    global board, open_positions, solved_board
    board = [([0] * 9) for _ in range(9)]
    open_positions = []
    solved_board = []

def get_valid_digits(r, c):
    global board
    allowed = [True] * 10
    # Check row and column
    for i in range(9):
        allowed[board[r][i]] = False
        allowed[board[i][c]] = False
    # Check box
    r_start = (r // 3) * 3
    c_start = (c // 3) * 3
    for i in range(r_start, r_start + 3):
        for j in range(c_start, c_start + 3):
            allowed[board[i][j]] = False
    valid_digits = []    
    for i in range(10):
        if allowed[i]:
            valid_digits.append(i)
    return valid_digits

def generate_open_positions():
    global open_positions, board
    for i in range(9):
        for j in range(9):
            if board[i][j] == 0:
                open_positions.append((i, j))

def copy_board_to_solved_board():
    global solved_board, board
    for i in range(9):
        solved_board.append(board[i][:])

def solve_sudoku(p):
    global open_positions, board, solved_board
    if p >= len(open_positions):
        copy_board_to_solved_board()
        return

    r, c = open_positions[p]
    valid_digits = get_valid_digits(r, c) 
    for d in valid_digits:
        board[r][c] = d
        solve_sudoku(p + 1)
        board[r][c] = 0

def initialize_board(A):
    global board
    for i in range(9):
        for j in range(9):
            if A[i][j] != '.':
                board[i][j] = int(A[i][j])

def solve(A):
    reset_globals()
    initialize_board(A)
    generate_open_positions()
    solve_sudoku(0)
    
    for i in range(9):
        t = ''
        for j in range(9):
            t += str(solved_board[i][j])
        A[i] = t
    # return ans

class Solution:
    # @param A : list of list of chars
    # @return nothing
    def solveSudoku(self, A):
        solve(A)

A = [ 
    "53..7....", 
    "6..195...", 
    ".98....6.", 
    "8...6...3", 
    "4..8.3..1", 
    "7...2...6", 
    ".6....28.", 
    "...419..5", 
    "....8..79" 
]
Solution().solveSudoku(A)
print(A)
