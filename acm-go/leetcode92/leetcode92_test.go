package leetcode92

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestCase1(t *testing.T) {
	a := createNode(1)
	b := createNode(2)
	c := createNode(3)
	d := createNode(4)
	e := createNode(5)
	joinNodes([]*ListNode{a, b, c, d, e})
	head := reverseBetween(a, 2, 4)
	assert.True(t, verifyList(head, []*ListNode{a, d, c, b, e}))
}

func TestCase2(t *testing.T) {
	a := createNode(5)
	head := reverseBetween(a, 1, 1)
	assert.True(t, verifyList(head, []*ListNode{a}))
}

// Helpers

func createNode(val int) *ListNode {
	return &ListNode{val, nil}
}

func joinNodes(nodes []*ListNode) {
	for i := 1; i < len(nodes); i++ {
		nodes[i-1].Next = nodes[i]
	}
}

func verifyList(head *ListNode, nodes []*ListNode) bool {
	curr := head
	for _, node := range nodes {
		if curr == nil || curr != node {
			return false
		}
		curr = curr.Next
	}
	return curr == nil
}
