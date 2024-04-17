package leetcode274

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestCase1(t *testing.T) {
	assert.Equal(t, 3, hIndex([]int{3, 0, 6, 1, 5}))
}

func TestCase2(t *testing.T) {
	assert.Equal(t, 1, hIndex([]int{1, 3, 1}))
}
