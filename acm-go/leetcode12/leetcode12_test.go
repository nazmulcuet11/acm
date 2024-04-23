package leetcode12

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestCase1(t *testing.T) {
	assert.Equal(t, "III", intToRoman(3))
}

func TestCase2(t *testing.T) {
	assert.Equal(t, "LVIII", intToRoman(58))
}

func TestCase3(t *testing.T) {
	assert.Equal(t, "MCMXCIV", intToRoman(1994))
}
