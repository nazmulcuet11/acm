package leetcode146

type LRUList struct {
	Head *LRUListNode
	Tail *LRUListNode
}

func NewLRUList() *LRUList {
	return &LRUList{Head: nil, Tail: nil}
}

func (list *LRUList) pushBackNode(node *LRUListNode) {
	if list.Tail == nil {
		list.Head = node
	} else {
		node.Prev = list.Tail
		list.Tail.Next = node
	}
	list.Tail = node
}

func (list *LRUList) remove(node *LRUListNode) {
	if node == list.Head && node == list.Tail {
		list.Head = nil
		list.Tail = nil
	} else if node == list.Head {
		list.Head = node.Next
		list.Head.Prev = nil
	} else if node == list.Tail {
		list.Tail = node.Prev
		list.Tail.Next = nil
	} else {
		node.Prev.Next = node.Next
		node.Next.Prev = node.Prev
	}

	node.Next = nil
	node.Prev = nil
}

func (list *LRUList) moveToLast(node *LRUListNode) {
	list.remove(node)
	list.pushBackNode(node)
}
