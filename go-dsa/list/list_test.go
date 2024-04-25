package list

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestPushBack(t *testing.T) {
	list := NewList[int]()
	list.PushBack(1)
	list.PushBack(2)
	list.PushBack(3)
	assert.Equal(t, "[1, 2, 3]", list.String())
}

func TestPushFront(t *testing.T) {
	list := NewList[int]()
	list.PushFront(1)
	list.PushFront(2)
	list.PushFront(3)
	assert.Equal(t, "[3, 2, 1]", list.String())
}
