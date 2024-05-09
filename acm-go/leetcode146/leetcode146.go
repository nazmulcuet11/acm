package leetcode146

type LRUCache struct {
	capacity  int
	count     int
	keyToNode map[int]*LRUListNode
	list      *LRUList
}

func Constructor(capacity int) LRUCache {
	return LRUCache{
		capacity:  capacity,
		count:     0,
		keyToNode: make(map[int]*LRUListNode),
		list:      NewLRUList(),
	}
}

func (this *LRUCache) Get(key int) int {
	node, ok := this.keyToNode[key]
	if !ok {
		return -1
	}
	this.list.moveToLast(node)
	return node.Val
}

func (this *LRUCache) Put(key int, value int) {
	node, ok := this.keyToNode[key]
	if ok {
		// update
		node.Val = value
		this.list.moveToLast(node)
	} else {
		node = NewLRUListNode(key, value)
		if this.count == this.capacity {
			delete(this.keyToNode, this.list.Head.Key)
			this.list.remove(this.list.Head)
		} else {
			this.count++
		}
		this.keyToNode[key] = node
		this.list.pushBackNode(node)
	}
}
