package leetcode289

type move struct {
	x int
	y int
}

var moves = []move{
	{-1, -1},
	{-1, 0},
	{-1, 1},
	{0, -1},
	{0, 1},
	{1, -1},
	{1, 0},
	{1, 1},
}

func isValid(board [][]int, i int, j int) bool {
	return 0 <= i && i < len(board) && 0 <= j && j < len(board[0])
}

func isLive(board [][]int, i int, j int) bool {
	return board[i][j] == 1 || board[i][j] == -1
}

func adjacentLiveCount(board [][]int, i int, j int) int {
	count := 0
	for _, move := range moves {
		x := i + move.x
		y := j + move.y
		if isValid(board, x, y) && isLive(board, x, y) {
			count++
		}
	}
	return count
}

func gameOfLife(board [][]int) {
	for i := range board {
		for j := range board[i] {
			liveCount := adjacentLiveCount(board, i, j)
			if board[i][j] == 1 && (liveCount < 2 || liveCount > 3) {
				board[i][j] = -1 // dead in next phase
			} else if board[i][j] == 0 && liveCount == 3 {
				board[i][j] = -2 // live in next phase
			}
		}
	}

	for i := range board {
		for j := range board[i] {
			if board[i][j] == -1 {
				board[i][j] = 0
			} else if board[i][j] == -2 {
				board[i][j] = 1
			}
		}
	}
}
