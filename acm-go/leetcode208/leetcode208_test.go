package leetcode208

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestCase1(t *testing.T) {
	trie := Constructor()
	trie.Insert("apple")
	assert.Equal(t, true, trie.Search("apple"))   // return True
	assert.Equal(t, false, trie.Search("app"))    // return False
	assert.Equal(t, true, trie.StartsWith("app")) // return True
	trie.Insert("app")
	assert.Equal(t, true, trie.Search("app")) // return True
}
