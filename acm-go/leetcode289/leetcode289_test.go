package leetcode289

import (
	"reflect"
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestCase1(t *testing.T) {
	input := [][]int{
		{0, 1, 0},
		{0, 0, 1},
		{1, 1, 1},
		{0, 0, 0},
	}

	output := [][]int{
		{0, 0, 0},
		{1, 0, 1},
		{0, 1, 1},
		{0, 1, 0},
	}

	gameOfLife(input)
	assert.True(t, reflect.DeepEqual(output, input))
}

func TestCase2(t *testing.T) {
	input := [][]int{
		{1, 1},
		{1, 0},
	}

	output := [][]int{
		{1, 1},
		{1, 1},
	}

	gameOfLife(input)
	assert.True(t, reflect.DeepEqual(output, input))
}
