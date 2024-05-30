package leetcode909

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestCase1(t *testing.T) {
	board := [][]int{
		{-1, -1, -1, -1, -1, -1},
		{-1, -1, -1, -1, -1, -1},
		{-1, -1, -1, -1, -1, -1},
		{-1, 35, -1, -1, 13, -1},
		{-1, -1, -1, -1, -1, -1},
		{-1, 15, -1, -1, -1, -1},
	}
	assert.Equal(t, 4, snakesAndLadders(board))
}

func TestCase2(t *testing.T) {
	board := [][]int{
		{-1, -1},
		{-1, 3},
	}
	assert.Equal(t, 1, snakesAndLadders(board))
}
