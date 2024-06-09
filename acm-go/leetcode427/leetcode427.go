package leetcode427

import "fmt"

// Definition for a QuadTree node.
type Node struct {
	Val         bool
	IsLeaf      bool
	TopLeft     *Node
	TopRight    *Node
	BottomLeft  *Node
	BottomRight *Node
}

type GridRange struct {
	minR int
	minC int
	maxR int
	maxC int
}

func allEqual(grid [][]int, gr GridRange) bool {
	zeroCount := 0
	oneCount := 0
	for i := gr.minR; i <= gr.maxR; i++ {
		for j := gr.minC; j <= gr.maxC; j++ {
			if grid[i][j] == 0 {
				zeroCount++
			} else {
				oneCount++
			}

			if zeroCount > 0 && oneCount > 0 {
				return false
			}
		}
	}
	return true
}

func firstValue(grid [][]int, gr GridRange) bool {
	return grid[gr.minR][gr.minC] == 1
}

func splitRange(gr GridRange) (GridRange, GridRange, GridRange, GridRange) {
	dr := (gr.maxR + gr.minR) / 2
	dc := (gr.maxC + gr.minC) / 2

	tl := GridRange{
		gr.minR,
		gr.minC,
		dr,
		dc,
	}

	tr := GridRange{
		gr.minR,
		dc + 1,
		dr,
		gr.maxC,
	}

	bl := GridRange{
		dr + 1,
		gr.minC,
		gr.maxR,
		dc,
	}

	br := GridRange{
		dr + 1,
		dc + 1,
		gr.maxR,
		gr.maxC,
	}

	return tl, tr, bl, br
}

func solve(grid [][]int, gr GridRange) *Node {
	fmt.Println(gr)
	if allEqual(grid, gr) {
		return &Node{
			firstValue(grid, gr),
			true,
			nil,
			nil,
			nil,
			nil,
		}
	}

	tl, tr, bl, br := splitRange(gr)
	return &Node{
		firstValue(grid, gr),
		false,
		solve(grid, tl),
		solve(grid, tr),
		solve(grid, bl),
		solve(grid, br),
	}
}

func construct(grid [][]int) *Node {
	n := len(grid)
	if n == 0 {
		return nil
	}

	gr := GridRange{
		0,
		0,
		n - 1,
		n - 1,
	}
	return solve(grid, gr)
}
