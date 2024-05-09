package leetcode146

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestCase1(t *testing.T) {
	lruCache := Constructor(2)
	lruCache.Put(1, 1)                   // cache is {1=1}
	lruCache.Put(2, 2)                   // cache is {1=1, 2=2}
	assert.Equal(t, 1, lruCache.Get(1))  // return 1
	lruCache.Put(3, 3)                   // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
	assert.Equal(t, -1, lruCache.Get(2)) // returns -1 (not found)
	lruCache.Put(4, 4)                   // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
	assert.Equal(t, -1, lruCache.Get(1)) // return -1 (not found)
	assert.Equal(t, 3, lruCache.Get(3))  // return 3
	assert.Equal(t, 4, lruCache.Get(4))  // return 4
}

func TestCase2(t *testing.T) {
	lruCache := Constructor(2)
	lruCache.Put(2, 1)                   // cache is {1=1}
	lruCache.Put(1, 1)                   // cache is {1=1, 2=1}
	lruCache.Put(2, 3)                   // cache is {1=1, 2=3}
	lruCache.Put(4, 1)                   // cache is {2=3, 4=1}
	assert.Equal(t, -1, lruCache.Get(1)) // return -1 (not found)
	assert.Equal(t, 3, lruCache.Get(2))  // return 3
}
