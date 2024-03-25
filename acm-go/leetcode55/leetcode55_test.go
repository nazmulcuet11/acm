package leetcode55

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestCase1(t *testing.T) {
	assert.Equal(t, true, canJump([]int{2, 3, 1, 1, 4}))
}

func TestCase2(t *testing.T) {
	assert.Equal(t, false, canJump([]int{3, 2, 1, 0, 4}))
}

func TestCase3(t *testing.T) {
	assert.Equal(t, true, canJump([]int{2, 0}))
}
