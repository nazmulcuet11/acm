package leetcode130

var moves = []struct {
	x int
	y int
}{
	{-1, 0},
	{0, 1},
	{1, 0},
	{0, -1},
}

func mark(grid [][]byte, i int, j int, current byte, target byte) {
	if i < 0 || i >= len(grid) || j < 0 || j >= len(grid[i]) || grid[i][j] != current {
		return
	}

	grid[i][j] = target
	for _, move := range moves {
		mark(grid, i+move.x, j+move.y, current, target)
	}
}

func solve(board [][]byte) {
	m := len(board)
	if m == 0 {
		return
	}
	n := len(board[0])

	for i := 0; i < m; i++ {
		if board[i][0] == 'O' {
			mark(board, i, 0, 'O', 'U')
		}
		if board[i][n-1] == 'O' {
			mark(board, i, n-1, 'O', 'U')
		}
	}

	for i := 0; i < n; i++ {
		if board[0][i] == 'O' {
			mark(board, 0, i, 'O', 'U')
		}
		if board[m-1][i] == 'O' {
			mark(board, m-1, i, 'O', 'U')
		}
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if board[i][j] == 'O' {
				board[i][j] = 'X'
			}
		}
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if board[i][j] == 'U' {
				board[i][j] = 'O'
			}
		}
	}
}
