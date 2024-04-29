package list

import "fmt"

type List[T any] struct {
	head *Node[T]
	tail *Node[T]
}

func NewList[T any]() *List[T] {
	return &List[T]{}
}

func (this *List[T]) PushBack(data T) {
	node := &Node[T]{data: data}
	if this.tail == nil {
		this.head = node
	} else {
		node.prev = this.tail
		this.tail.next = node
	}
	this.tail = node
}

func (this *List[T]) PushFront(data T) {
	node := &Node[T]{data: data}
	if this.tail == nil {
		this.tail = node
	} else {
		node.next = this.head
		this.head.prev = node
	}
	this.head = node
}

func (l *List[T]) String() string {
	r := "["
	for e := l.head; e != nil; e = e.next {
		if r == "[" {
			r += fmt.Sprintf("%v", e.data)
		} else {
			r += fmt.Sprintf(", %v", e.data)
		}
	}
	r += "]"
	return r
}
