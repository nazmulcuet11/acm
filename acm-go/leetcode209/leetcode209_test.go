package leetcode209

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestCase1(t *testing.T) {
	assert.Equal(t, 2, minSubArrayLen(7, []int{2, 3, 1, 2, 4, 3}))
}

func TestCase2(t *testing.T) {
	assert.Equal(t, 1, minSubArrayLen(4, []int{1, 4, 4}))
}

func TestCase3(t *testing.T) {
	assert.Equal(t, 0, minSubArrayLen(11, []int{1, 1, 1, 1, 1, 1, 1, 1}))
}
