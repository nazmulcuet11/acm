package leetcode134

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestCase1(t *testing.T) {
	assert.Equal(t, 3, canCompleteCircuit([]int{1, 2, 3, 4, 5}, []int{3, 4, 5, 1, 2}))
}

func TestCase2(t *testing.T) {
	assert.Equal(t, -1, canCompleteCircuit([]int{2, 3, 4}, []int{3, 4, 3}))
}
