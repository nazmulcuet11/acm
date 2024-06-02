package leetcode211

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestCase1(t *testing.T) {
	wordDictionary := Constructor()
	wordDictionary.AddWord("bad")
	wordDictionary.AddWord("dad")
	wordDictionary.AddWord("mad")
	assert.False(t, wordDictionary.Search("pad")) // return False
	assert.True(t, wordDictionary.Search("bad"))  // return True
	assert.True(t, wordDictionary.Search(".ad"))  // return True
	assert.True(t, wordDictionary.Search("b.."))  // return True
}
