package leetcode17

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestCase1(t *testing.T) {
	assert.Equal(t, []string{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"}, letterCombinations("23"))
}

func TestCase2(t *testing.T) {
	assert.Equal(t, []string{}, letterCombinations(""))
}
