package leetcode452

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestCase1(t *testing.T) {
	assert.Equal(
		t,
		2,
		findMinArrowShots([][]int{{10, 16}, {2, 8}, {1, 6}, {7, 12}}),
	)
}

func TestCase2(t *testing.T) {
	assert.Equal(
		t,
		4,
		findMinArrowShots([][]int{{1, 2}, {3, 4}, {5, 6}, {7, 8}}),
	)
}

func TestCase3(t *testing.T) {
	assert.Equal(
		t,
		2,
		findMinArrowShots([][]int{{1, 2}, {2, 3}, {3, 4}, {4, 5}}),
	)
}
