package leetcode148

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestCase1(t *testing.T) {
	head := &ListNode{4, &ListNode{2, &ListNode{1, &ListNode{3, nil}}}}
	sorted := sortList(head)
	assert.Equal(t, sorted.Val, 1)
	assert.Equal(t, sorted.Next.Val, 2)
	assert.Equal(t, sorted.Next.Next.Val, 3)
	assert.Equal(t, sorted.Next.Next.Next.Val, 4)
}
