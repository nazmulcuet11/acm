package leetcode208

type TrieNode struct {
	children map[rune]*TrieNode
	isEnding bool
}

func CreateTrieNode() *TrieNode {
	return &TrieNode{
		children: make(map[rune]*TrieNode),
		isEnding: false,
	}
}

type Trie struct {
	head *TrieNode
}

func Constructor() Trie {
	return Trie{CreateTrieNode()}
}

func (this *Trie) Insert(word string) {
	curr := this.head
	for _, c := range word {
		_, ok := curr.children[c]
		if !ok {
			curr.children[c] = CreateTrieNode()
		}
		curr = curr.children[c]
	}
	curr.isEnding = true
}

func (this *Trie) Search(word string) bool {
	node := this.SearchHelper(word)
	return node != nil && node.isEnding
}

func (this *Trie) StartsWith(prefix string) bool {
	node := this.SearchHelper(prefix)
	return node != nil
}

func (this *Trie) SearchHelper(word string) *TrieNode {
	curr := this.head
	for _, c := range word {
		_, ok := curr.children[c]
		if !ok {
			return nil
		}
		curr = curr.children[c]
	}
	return curr
}
