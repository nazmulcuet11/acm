package leetcode146

type LRUListNode struct {
	Key  int
	Val  int
	Next *LRUListNode
	Prev *LRUListNode
}

func NewLRUListNode(key int, val int) *LRUListNode {
	return &LRUListNode{Key: key, Val: val, Next: nil, Prev: nil}
}
