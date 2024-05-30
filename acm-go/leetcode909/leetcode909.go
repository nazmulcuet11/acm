package leetcode909

type Coordinate struct {
	X int
	Y int
}

func snakesAndLadders(board [][]int) int {
	n := len(board)
	u := 1
	numberToCoordinate := make(map[int]Coordinate, 0)
	for i := n - 1; i >= 0; i-- {
		ltr := (n-1-i)%2 == 0
		for j := 0; j < n; j++ {
			x := i
			var y int
			if ltr {
				y = j
			} else {
				y = n - 1 - j
			}

			coordinate := Coordinate{x, y}
			numberToCoordinate[u] = coordinate
			u++
		}
	}

	queue := make([]int, 0)
	cost := make([]int, n*n+1)
	for i := range n*n + 1 {
		cost[i] = -1
	}

	queue = append(queue, 1)
	cost[1] = 0
	for len(queue) > 0 {
		newQueue := make([]int, 0)
		for _, u := range queue {
			for c := u + 1; c <= min(u+6, n*n); c++ {
				cCoordinate := numberToCoordinate[c]
				var v int
				if board[cCoordinate.X][cCoordinate.Y] != -1 {
					v = board[cCoordinate.X][cCoordinate.Y]
				} else {
					v = c
				}

				if cost[v] == -1 {
					cost[v] = cost[u] + 1
					newQueue = append(newQueue, v)
				}

			}
		}
		queue = newQueue
	}

	return cost[n*n]
}
