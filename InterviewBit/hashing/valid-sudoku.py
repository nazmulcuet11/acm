class Solution:
    # @param A : tuple of strings
    # @return an integer
    def isValidSudoku(self, board):
        # validate rows
        for r in range(9):
            seen = [False] * 10
            for c in range(9):
                if board[r][c] == '.':
                    continue
                d = int(board[r][c])
                if seen[d]:
                    return 0
                seen[d] = True

        # Validate columns
        for c in range(9):
            seen = [False] * 10
            for r in range(9):
                if board[r][c] == '.':
                    continue
                d = int(board[r][c])
                if seen[d]:
                    return 0
                seen[d] = True

        # validate boxes
        for br in range(0, 9, 3):
            for bc in range(0, 9, 3):
                seen = [False] * 10
                for i in range(br, br + 3):
                    for j in range(bc, bc + 3):
                        if board[i][j] == '.':
                            continue
                        d = int(board[i][j])
                        if seen[d]:
                            return 0
                        seen[d] = True
        return 1
