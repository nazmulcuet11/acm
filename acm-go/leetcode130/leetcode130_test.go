package leetcode130

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestCase1(t *testing.T) {
	board := [][]byte{
		{'X', 'X', 'X', 'X'},
		{'X', 'O', 'O', 'X'},
		{'X', 'X', 'O', 'X'},
		{'X', 'O', 'X', 'X'},
	}
	expected := [][]byte{
		{'X', 'X', 'X', 'X'},
		{'X', 'X', 'X', 'X'},
		{'X', 'X', 'X', 'X'},
		{'X', 'O', 'X', 'X'},
	}
	solve(board)
	assert.Equal(t, board, expected)
}

func TestCase2(t *testing.T) {
	board := [][]byte{
		{'O', 'O', 'O', 'O', 'X', 'X'},
		{'O', 'O', 'O', 'O', 'O', 'O'},
		{'O', 'X', 'O', 'X', 'O', 'O'},
		{'O', 'X', 'O', 'O', 'X', 'O'},
		{'O', 'X', 'O', 'X', 'O', 'O'},
		{'O', 'X', 'O', 'O', 'O', 'O'},
	}
	expected := [][]byte{
		{'O', 'O', 'O', 'O', 'X', 'X'},
		{'O', 'O', 'O', 'O', 'O', 'O'},
		{'O', 'X', 'O', 'X', 'O', 'O'},
		{'O', 'X', 'O', 'O', 'X', 'O'},
		{'O', 'X', 'O', 'X', 'O', 'O'},
		{'O', 'X', 'O', 'O', 'O', 'O'},
	}
	solve(board)
	assert.Equal(t, board, expected)
}
