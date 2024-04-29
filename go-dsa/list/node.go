package list

type Node[T any] struct {
	data T
	prev *Node[T]
	next *Node[T]
}

func NewNode[T any](data T) *Node[T] {
	return &Node[T]{data: data}
}
