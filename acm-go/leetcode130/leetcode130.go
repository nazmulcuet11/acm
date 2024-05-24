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

func isBounded(grid [][]byte, i int, j int) bool {
	if i < 0 || i >= len(grid) || j < 0 || j >= len(grid[i]) {
		return false
	}

	if grid[i][j] != 'O' {
		return true
	}

	grid[i][j] = 'V'
	ans := true
	for _, move := range moves {
		next := isBounded(grid, i+move.x, j+move.y)
		ans = ans && next
	}
	return ans
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

// func printBoard(board [][]byte) {
// 	fmt.Println("Board")
// 	fmt.Println("-------------")
// 	for _, row := range board {
// 		fmt.Println(string(row))
// 	}
// 	fmt.Println("-------------")
// }

func solve(board [][]byte) {
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[i]); j++ {
			if board[i][j] == 'O' {
				if isBounded(board, i, j) {
					// printBoard(board)
					mark(board, i, j, 'V', 'B')
					// printBoard(board)
				} else {
					// printBoard(board)
					mark(board, i, j, 'V', 'U')
					// printBoard(board)
				}
			}
		}
	}

	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[i]); j++ {
			if board[i][j] == 'B' {
				mark(board, i, j, 'B', 'X')
			} else if board[i][j] == 'U' {
				mark(board, i, j, 'U', 'O')
			}
		}
	}
}
